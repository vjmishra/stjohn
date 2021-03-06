#!/bin/sh

# Minimal jar file to get JBoss started.

JBOSS_CLASSPATH=$JBOSS_CLASSPATH:run.jar

# Add all login modules for JAAS-based security
# and all libraries that are used by them here
JBOSS_CLASSPATH=$JBOSS_CLASSPATH

# Check for SUN(tm) JVM w/ HotSpot support
#
HOTSPOT=`java -version 2>&1 | grep HotSpot`"x"
if [ "$HOTSPOT" != "x" ]; then
       HOTSPOT="-server"
else
       HOTSPOT=""
fi

# Add the XML parser jars and set the JAXP factory names
# Crimson parser JAXP setup(default)
JBOSS_CLASSPATH=$JBOSS_CLASSPATH:../lib/crimson.jar
JAXP=-Djavax.xml.parsers.DocumentBuilderFactory=org.apache.xerces.jaxp.DocumentBuilderFactoryImpl
JAXP="$JAXP -Djavax.xml.parsers.SAXParserFactory=org.apache.xerces.jaxp.DocumentBuilderFactoryImpl"

echo JBOSS_CLASSPATH=$JBOSS_CLASSPATH
java $HOTSPOT $JAXP -Xms128m -Xmx512m \
  -classpath $JBOSS_CLASSPATH org.jboss.Main $@

