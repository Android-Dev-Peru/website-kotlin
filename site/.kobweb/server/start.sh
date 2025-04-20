#!/bin/bash

# Find the kobweb project folder, using this file's location to start form
cd "$(dirname "$0")"
cd ../..

args="-Dkobweb.server.environment=PROD -Dkobweb.site.layout=STATIC -Dio.ktor.development=false -jar .kobweb/server/server.jar"

if [ -n "$KOBWEB_JAVA_HOME" ]; then
    java_cmd="$KOBWEB_JAVA_HOME/bin/java"
elif [ -n "$JAVA_HOME" ]; then
    java_cmd="$JAVA_HOME/bin/java"
else
    java_cmd="java"
fi

"$java_cmd" $args