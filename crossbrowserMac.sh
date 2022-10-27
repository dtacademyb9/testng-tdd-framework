#!/bin/sh
mvn test -D xmlFile=smoke-tests.xml -D browser=chrome
mvn test -D xmlFile=smoke-tests.xml -D browser=firefox
mvn test -D xmlFile=smoke-tests.xml -D browser=edge