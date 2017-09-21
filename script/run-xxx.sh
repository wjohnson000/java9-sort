#!/bin/bash

JAVA_HOME_9="C:/Program Files/Java/jdk-9"
JAVA_OPTS="-Xms32m -Xmx64m -Xss12m"

# echo "${JAVA_HOME_9}/bin/java" --module-path ../mod --class-path "../lib/itextpdf-5.5.9.jar" ${JAVA_OPTS} -m java.nine.sort/sort.java9.itext.CreatePDF
# "${JAVA_HOME_9}/bin/java" --module-path ../mod --class-path "../lib/itextpdf-5.5.9.jar" ${JAVA_OPTS} -m java.nine.sort/sort.java9.itext.CreatePDF

# "C:/Program Files/Java/jdk-9/bin/javaw.exe" -agentlib:jdwp=transport=dt_socket,suspend=y,address=localhost:62551 -Dfile.encoding=UTF-8 -p C:/Users/wjohnson000/Documents/sort/workspace9/java9-sort/bin -classpath C:/Users/wjohnson000/Documents/sort/workspace9/java9-sort/lib/itextpdf-5.5.9.jar -m java.nine.sort/sort.java9.examples.Ex04_FindExistingProcess

"${JAVA_HOME_9}/bin/java" --module-path ../mod --class-path "../lib/itextpdf-5.5.9.jar" ${JAVA_OPTS} -m java.nine.sort/sort.java9.itext.CreatePDF
