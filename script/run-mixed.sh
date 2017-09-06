#!/bin/bash

JAVA_HOME_9="C:/Program Files/Java/jdk-9"
JAVA_OPTS="-Xms32m -Xmx64m -Xss12m"

echo "${JAVA_HOME_9}/bin/java" --module-path ../mod --class-path "../lib/itextpdf-5.5.9.jar" ${JAVA_OPTS} -m java.nine.sort/sort.java9.itext.CreatePDF
"${JAVA_HOME_9}/bin/java" --module-path ../mod --class-path "../lib/itextpdf-5.5.9.jar" ${JAVA_OPTS} -m java.nine.sort/sort.java9.itext.CreatePDF
