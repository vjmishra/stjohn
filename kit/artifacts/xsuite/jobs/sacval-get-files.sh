
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

# before continuing, make sure the Sac-Val site is up
expectOne=` sh ${XFTP_DIR}/sacval_check.sh | grep DONE | wc -l`
if [ $expectOne -lt 1 ]
then
   echo "Exception, Sac-Val does not seem to be operational."
   rm $lockfile
   exit
fi

logtstamp=`date '+%Y%m%d.%H%M%S'`

logDir=$XSUITE_HOME/xsuite/edi/processed_log
logFile=${logDir}/sacval_get_$logtstamp.log




cd $XDIR/edi
indir=inbound_sacval

if [ ! -d $indir ]
then
  mkdir $indir
fi

cd $indir

# get the file(s) from Sac-Val using ftp.
echo " === " > ${logFile}
sh ${XFTP_DIR}/sacval_get.sh >> ${logFile}

# parse each of the files downloaded.
flist=`ls -1`
for frcvd in $flist
do
    tstamp=`date '+%Y%m%d%H%M%S'`
    outFile="fa997_cleanwise.dat.${tstamp}.txt" 
    sh ${XFTP_DIR}/cwii_to_archrcv.sh $frcvd SacVal >> ${logFile}



    # parse the file received
    java -classpath "${TJCPATH}" \
             -Duser.home=${XSUITE_HOME}/xsuite/edi/tools/oboe \
             -Dconf="${XSUITE_HOME}/xsuite/app.properties" \
             -Difile=$frcvd -Dofile=$outFile \
            com.cleanwise.service.apps.dataexchange.InboundTranslate >> ${logFile} 2>&1


    mv $frcvd $XDIR/edi/processed

    if [ -f $outFile ] && [ -s $outFile ]
    then
      sh ${XFTP_DIR}/cwii_send.sh $outFile SacVal >> ${logFile}
      sh ${XFTP_DIR}/sacval_send.sh $outFile >> ${logFile}
      mv $outFile $XDIR/edi/sent
    fi

    if [ -f $outFile ]
    then
      echo "produced an empty file $outFile" >> ${logFile}
      rm ${outFile}
    fi

done

rm $lockfile

# we should be done processing files
fl=`ls -1`
if [ "x" = "x$fl" ]
then
  echo "All done, no files left."
else
  echo "Exception: files $fl were not processed in $indir" >> $logFile
fi

mail jobreporting@cleanwise.com <<EOF
subject: $0 done

--- Sac-Val Link file processing ---

`cat $logFile`

EOF

