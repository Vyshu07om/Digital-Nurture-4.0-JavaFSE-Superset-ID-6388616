@echo off
echo ========================================
echo Singleton Pattern Example - Build & Run
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

echo Running Singleton Test...
java -cp src/main/java SingletonTest
echo.

echo ========================================
echo Test completed!
echo ========================================
pause 