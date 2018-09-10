#!/usr/bin/env bash

while ! nc -z ${MYSQL_IP} ${MYSQL_PORT};
do
    sleep 3;
    echo "waiting";
    echo "${MYSQL_IP}:${MYSQL_PORT}"
done
echo "${MYSQL_IP}:${MYSQL_PORT}"
java -jar /test.jar