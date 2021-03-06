#!/bin/bash

# This script runs the Charva test program (if it is invoked as
# "test.sh swing", then the Swing version of the tutorial application
# is started instead).


# JAVA_HOME must be set to the JDK or JRE installation directory (for example,
# /usr/local/jdk1.4 or /usr/local/jre1.4).
clear

HOME_PATH="/home/gabriel/eclipseprojects/CharvaHelloWorld/"
export LD_LIBRARY_PATH=${HOME_PATH}run/


# Uncomment the next line to log keystrokes and mouse-clicks, and 
# to debug key-mappings (the logfile in this case is $HOME/script.charva).
TEST_OPTS="-Dcharva.script.record=${HOME}/script.charva"

# Uncomment the following line to play back a script that was previously
# recorded using "charva.script.record".
# This line will cause the script to loop three times, at a speeded-up rate (5 times the speed of the recording).
#TEST_OPTS="-Dcharva.script.playbackFile=${HOME}/script.charva -Dcharva.script.playbackLoops=3 -Dcharva.script.playbackRate=5"

# Uncomment the next line to enable color.
TEST_OPTS="${TEST_OPTS} -Dcharva.color=1"

# Uncomment the following option to test for memory leaks.
#TEST_OPTS="${TEST_OPTS} -Xrunhprof:heap=sites"

# Note that the "-classic" option is no longer supported in JDK1.4,
# but in JDK1.3 and earlier it is useful on Linux because otherwise
# (on Linux kernels before 2.6) each Charva application shows up as
# dozens of processes (one for each thread).
#TEST_OPTS="-classic ${TEST_OPTS}"

# Uncomment the following line if you want to debug the application
# using an IDE such as IntelliJ IDEA (I believe that other IDEs such
# as NetBeans and JBuilder have the same capability).
TEST_OPTS="${TEST_OPTS} -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"



echo Creating .jar ...
cd ../src/main
rm *.class

javac -cp ".:${HOME_PATH}lib/charva.jar" *.java
jar cvfe program.jar program *.class

CLASS_PATH=".:main/:${HOME_PATH}run/commons-logging.jar:${HOME_PATH}run/log4j-1.2.8.jar:${HOME_PATH}src:${HOME_PATH}run/classes:${HOME_PATH}lib/mysql-connector-java-3.1.14-bin"


${JAVA_HOME}/bin/java \
    ${TEST_OPTS} \
    -cp "${CLASS_PATH}" \
    main.Main 2> charva.log
    
    
#${JAVA_HOME}/bin/java \
#    ${TEST_OPTS} \
#    -cp ".:main/:${HOME_PATH}run/commons-logging.jar:${HOME_PATH}run/log4j-1.2.8.jar:${HOME_PATH}src:${HOME_PATH}run/classes" \
#    main.Main 2> charva.log    

stty sane