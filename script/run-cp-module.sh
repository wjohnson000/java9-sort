#!/bin/bash

JAVA_HOME_9="C:/Program Files/Java/jdk-9"
JAVA_OPTS="-Xms32m -Xmx64m -Xss12m"

echo "${JAVA_HOME_9}/bin/java" --module-path mod -classpath 'lib/*.jar' ${JAVA_OPTS} -m sort2017.java9/sort2017.java9.DumpSchema
"${JAVA_HOME_9}/bin/java" --module-path mod -classpath 'lib/*.jar' ${JAVA_OPTS} -m sort2017.java9/sort2017.java9.DumpSchema
