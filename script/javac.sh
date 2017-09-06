JAVA_HOME_9="C:/Program Files/Java/jdk-9"

find ../src -name "*.java" > sources.txt

"${JAVA_HOME_9}/bin/javac" --module-path ../lib  -d ../bin @sources.txt 
