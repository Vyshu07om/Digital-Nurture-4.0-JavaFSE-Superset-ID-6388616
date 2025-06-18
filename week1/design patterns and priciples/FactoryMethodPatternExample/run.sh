#!/bin/bash

echo "========================================"
echo "Factory Method Pattern - Build & Run"
echo "========================================"
echo

echo "Compiling Java files..."
javac src/main/java/*.java
if [ $? -ne 0 ]; then
    echo "Error: Compilation failed!"
    exit 1
fi
echo "✓ Compilation successful!"
echo

echo "Running Factory Method Test..."
java -cp src/main/java FactoryMethodTest
echo

echo "========================================"
echo "Test completed!"
echo "========================================" 