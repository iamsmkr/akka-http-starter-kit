#!/bin/bash

BIN_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
HOME_DIR="$(dirname "$BIN_DIR")"
CONF_DIR="${HOME_DIR}/conf"
LIB_DIR="${HOME_DIR}/lib"
LOG_DIR="${HOME_DIR}/logs"

if [ ! -d ${CONF_DIR} ] || [ ! -d ${LIB_DIR} ] || [ ! -d ${LOG_DIR} ]; then
  echo "`date`: Mandatory directory check failed."
  exit 0
fi

nohup java -server -Dhelloworld.home="${HOME_DIR}" -Dhelloworld.conf="${CONF_DIR}" -cp "${LIB_DIR}/*:${CONF_DIR}/*" \
	com.codingkapoor.helloworld.core.HelloWorld > "${LOG_DIR}/stdout.log" 2>&1 &

helloworld_pid=$!

echo
echo "HelloWorld API server started with PID [$helloworld_pid] at [`date`]"
