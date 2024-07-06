
@echo off
set CLASSPATH=lib\postgresql-42.2.20.jar;src
javac -d bin src\*.java
java -cp bin;lib\postgresql-42.2.20.jar LivrariaVirtual
