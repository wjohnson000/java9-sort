#!/bin/bash

JAVA_HOME_9="C:/Program Files/Java/jdk-9"
JAVA_OPTS="-Xms32m -Xmx64m -Xss12m"

# "${JAVA_HOME_9}/bin/jlink" --output stand-alone --add-modules sort2017.java9,postgresql --module-path "${JAVA_HOME_9}/jmods;mod" --launcher start-app=sort2017.java9/sort2017.java9.DumpSchema
"${JAVA_HOME_9}/bin/jlink" --output stand-alone --add-modules sort2017.java9 --module-path "${JAVA_HOME_9}/jmods;mod" --launcher start-app=sort2017.java9/sort2017.java9.DumpSchema
