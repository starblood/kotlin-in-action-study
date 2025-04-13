@echo off
echo Running spotlessApply to auto-format your code...
call gradlew.bat spotlessApply

echo.
echo Running spotlessCheck to validate formatting...
call gradlew.bat spotlessCheck

echo.
echo Done.
pause
