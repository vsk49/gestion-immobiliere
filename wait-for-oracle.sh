#!/bin/sh
set -e
host="db"
port=1521

echo "Waiting for Oracle DB to be available at $host:$port..."
while ! nc -z $host $port; do
  sleep 2
done
echo "Oracle DB is up!"