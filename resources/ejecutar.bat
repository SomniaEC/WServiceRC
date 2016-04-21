@ECHO OFF

SETLOCAL EnableDelayedExpansion

SET JVM_PATH="E:\Java\jdk1.7.0_45\bin\java"
SET CLASS_PATH=registroCivil.jar


java -classpath %CLASS_PATH% com.sommnia.registroCivil.webService.client.Client
