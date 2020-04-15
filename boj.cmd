@echo off
cd scripts
set filename=%1
shift
node dist/bin/%filename% %*
cd ..