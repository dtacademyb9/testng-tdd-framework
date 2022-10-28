call mvn test -D xmlFile=smoke-tests.xml -D browser=chrome
call mvn test -D xmlFile=smoke-tests.xml -D browser=firefox
call mvn test -D xmlFile=smoke-tests.xml -D browser=edge

:: run this file thru cmd using the name of the file -> crossbrowser.bat