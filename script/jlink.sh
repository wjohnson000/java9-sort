#!/bin/bash

JAVA_HOME_9="C:/Program Files/Java/jdk-9"
JAVA_OPTS="-Xms32m -Xmx64m -Xss12m"

"${JAVA_HOME_9}/bin/jlink" --output ../stand-alone --add-modules java.nine.sort --module-path "${JAVA_HOME_9}/jmods;../mod;../lib" --launcher start-app=java.nine.sort/sort.java9.itext.DumpSchema
