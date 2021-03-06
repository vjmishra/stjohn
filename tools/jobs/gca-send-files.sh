#!/bin/sh
lockfile=/tmp/$0.lockfile
if [ -f $lockfile ]
then
  echo "error lock file $lockfile in place."
  exit
fi

echo $$ > $lockfile

if [ -f  /apps/xadmin3/.profile ]
then
	. /apps/xadmin3/.profile 
fi

cd $XDIR
. app.sh.env

if [ -z ${XSUITE_HOME} ] 
then
  echo "XSUITE_HOME is not defined."
  exit
fi

expectOne=` sh ${XFTP_DIR}/gca_check.sh | grep DONE | wc -l`
if [ $expectOne -lt 1 ]
then
   echo "Exception, GCA does not seem to be operational."
   rm $lockfile
   exit
fi

logtstamp=`date '+%Y%m%d.%H%M%S'`

logDir=$XSUITE_HOME/xsuite/edi/processed_log
logFile=${logDir}/gca_send_$logtstamp.log



cd $XDIR/dataexchange
outdir=gca_outbound
archdir=$XDIR/dataexchange/sent

if [ ! -d $outdir ]
then
  mkdir $outdir
fi

if [ ! -d $archdir ]
then
  mkdir $archdir
fi

cd $outdir

BUS_ENT_IDS=101250

tstamp=`date '+%Y%m%d%H%M%S'`  
### START invoice generation 
outFile=inv_cleanwise.dat.${tstamp}.edi

java -classpath "${TJCPATH}" \
 -Duser.home=${XSUITE_HOME}/xsuite/edi/tools/oboe \
 -Dconf="${XSUITE_HOME}/xsuite/app.properties" \
 -Dofile=$outFile -DbusEntityIdList=${BUS_ENT_IDS} -Dtype=810 \
com.cleanwise.service.apps.dataexchange.OutboundTranslate >> ${logFile} 2>&1


if [ -s $outFile ] 
then
	echo ${XFTP_DIR}/cwii_send.sh $outFile GCA
      sh ${XFTP_DIR}/cwii_send.sh $outFile GCA >> ${logFile}
      sh ${XFTP_DIR}/gca_send.sh $outFile invoicedata >> ${logFile}
      mv $outFile $archdir
else
  echo "No 810 generated for id ${BUS_ENT_IDS}"
  rm -f $outFile
fi

### END 850 generation 

rm $lockfile

maillist=jobreporting@cleanwise.com
mail ${maillist} <<EOF
subject: $0 ${outFile} processed

--- $0 

`cat $logFile`

EOF           
