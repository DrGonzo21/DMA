#!/bin/zsh
mvn test -D xmlFile=smoke-tests.xml -D browser=chrome
mvn test -D xmlFile=smoke-tests.xml -D browser=safari
