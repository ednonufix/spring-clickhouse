#!/bin/bash

echo "Launching app"

jarfile=$(find /app/build/libs/*.jar | head -1)

echo "$jarfile"

java -XX:+FlightRecorder -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000 -jar "$jarfile"