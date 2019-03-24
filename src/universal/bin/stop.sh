#!/bin/bash

PID=`jps | grep HelloWorld | awk '{print $1}'`

COUNTER=0

if [ "${#PID}" -gt 0 ]
then
	kill ${PID}
	while [[ ( -d /proc/${PID} ) && ( -z `grep zombie /proc/${PID}/status` ) ]]
	do
    	echo "`date`: Waiting for HelloWorld API server to stop gracefully."
    	sleep 10
    	COUNTER=$(($COUNTER+1))
    	if [ "$COUNTER" -gt 10 ]; then kill -9 ${PID}; break; fi
	done
	echo "`date`: HelloWorld API server has stopped."
else
	echo "`date`: HelloWorld API server was not running."
fi
