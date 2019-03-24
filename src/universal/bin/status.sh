#!/bin/bash

CHECK="com.codingkapoor.helloworld.core.HelloWorld"
PID=`jps | grep HelloWorld | awk '{print $1}'`
STATUS=$(ps aux | grep -v grep | grep ${CHECK})

if [ "${#STATUS}" -gt 0 ] && [ -n ${PID} ]; then
    echo "`date`: HelloWorld API server is running."
else
    echo "`date`: HelloWorld API server is not running."
    exit 1
fi
