@echo off
echo ========================================
echo Factory Method Pattern - Build & Run
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

echo Running Factory Method Test...
java -cp src/main/java FactoryMethodTest
echo.

echo ========================================
echo Test completed!
echo ========================================
pause 