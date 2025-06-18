#!/bin/bash

echo "========================================"
echo "E-commerce Search - Build & Run"
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

echo "Running E-commerce Search Test..."
java -cp src/main/java EcommerceSearchTest
echo

echo "========================================"
echo "Test completed!"
echo "========================================" 