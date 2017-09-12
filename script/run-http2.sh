#!/bin/bash

JAVA_HOME_9="C:/Program Files/Java/jdk-9"
JAVA_OPTS="-Xms32m -Xmx64m -Xss12m"

echo "${JAVA_HOME_9}/bin/java" -p "../mod;../lib" ${JAVA_OPTS} -m java.nine.sort/sort.java9.http.Http2GET
"${JAVA_HOME_9}/bin/java" -p "../mod;../lib" ${JAVA_OPTS} -m java.nine.sort/sort.java9.http.Http2GET

