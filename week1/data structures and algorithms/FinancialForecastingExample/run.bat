@echo off
echo ========================================
echo Financial Forecasting - Build & Run
echo ========================================
echo.

echo Compiling Java files...
javac src/main/java/*.java
if %errorlevel% neq 0 (
    echo Error: Compilation failed!
    pause
    exit /b 1
)
echo ✓ Compilation successful!
echo.

echo Running Financial Forecasting Test...
java -cp src/main/java FinancialForecastingTest
echo.

echo ========================================
echo Test completed!
echo ========================================
pause 