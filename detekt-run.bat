@echo off
echo Running detekt static analysis...
call gradlew.bat detekt
echo.
pause
