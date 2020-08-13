#!/bin/bash

javacc -OUTPUT_DIRECTORY=./src/Aiken ./src/Aiken/AikenFile.jj

javac ./src/Aiken/*.java

cd ./src

java Aiken.AikenFile $2 $3 < Aiken/$1

cd ..

pdflatex $3
