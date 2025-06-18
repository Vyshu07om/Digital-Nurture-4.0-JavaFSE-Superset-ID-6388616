#!/bin/bash

echo "========================================"
echo "Financial Forecasting - Build & Run"
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

echo "Running Financial Forecasting Test..."
java -cp src/main/java FinancialForecastingTest
echo

echo "========================================"
echo "Test completed!"
echo "========================================" 
 