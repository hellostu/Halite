#!/bin/bash

if [ ! -d build ]; then
    mkdir build;
fi;


javac -d build src/main/java/com/hellostu/halite/*.java
./halite -d "30 30" "java -cp ./build com.hellostu.halite.MyBot" "java -cp ./build com.hellostu.halite.MyBot"


if [ ! -d logs ]; then
    mkdir logs;
fi;

mv *.hlt logs