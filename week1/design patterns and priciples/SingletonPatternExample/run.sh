#!/bin/bash

echo "========================================"
echo "Singleton Pattern Example - Build & Run"
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

echo "Running Singleton Test..."
java -cp src/main/java SingletonTest
echo

echo "========================================"
echo "Test completed!"
echo "========================================" 