#!/bin/bash

javacc Aiken/AikenFile.jj

javac Aiken/*.java

java Aiken.AikenFile < Aiken/Exemple.txt
