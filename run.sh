#!/bin/bash

nohup $TOMCAT_HOME/bin/startup.sh
tail -f /dev/null
#java -jar /u01/middleware/order-service-0.0.1-SNAPSHOT.jar
#tail -f /dev/null