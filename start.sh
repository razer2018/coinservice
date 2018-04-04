#!/bin/sh
source /etc/profile
ROJECT_path=micro-service
ROJECT_name=micro-service

[ -f /data/apps/${ROJECT_path}/${ROJECT_name}.pid ] &&  kill -9 `cat /data/apps/${ROJECT_path}/${ROJECT_name}.pid`
[ -f /data/apps/${ROJECT_path}/${ROJECT_name}.pid ] &&  rm -f /data/apps/${ROJECT_path}/${ROJECT_name}.pid

/usr/bin/java -jar /data/apps/${ROJECT_path}/${ROJECT_name}.jar >/data/apps/$ROJECT_path/run.log 2>&1 &

echo $! >/data/apps/${ROJECT_path}/${ROJECT_name}.pid

exit 0

