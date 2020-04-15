@echo off
set filename=%1
shift
node scripts/dist/bin/%filename% %*
