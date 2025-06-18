@echo off
echo ========================================
echo E-commerce Search - Build & Run
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

echo Running E-commerce Search Test...
java -cp src/main/java EcommerceSearchTest
echo.

echo ========================================
echo Test completed!
echo ========================================
pause 