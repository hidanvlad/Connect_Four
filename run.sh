#!/bin/bash
# Compile and run script for Connect Four game

echo "Compiling Connect Four..."
javac -d bin src/main/java/com/connectfour/*.java

if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo "Starting Connect Four..."
    echo ""
    java -cp bin com.connectfour.Main
else
    echo "Compilation failed!"
    exit 1
fi
