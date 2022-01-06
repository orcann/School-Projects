#Project 1 RUFS phase 1
#Christopher Lee
#2/20/21
#Objectiv:
 RUFS is a simulated file system it will create files and directories in a memory then writes the file system to a binary file
#Starting:
to run you must have the c++ compiler CLANG 7 or above 
You must run make file which will compile all necessary files and create the executable RUFS
#instructions 
once RUFS is running the user will be directed to enter a list of commands: CreateFile, CreateDir, enddir, and quit;
The starting dir will be ./root
if user enters createfile they will be asked to provide the name of the file plus the extenstion text or program ".t" or ".p" and it will be stored in the current directory. 

for .t files the user is asked to enter the size of the contents and ascii text to be outputed later

.p user will be asked to enter in the Four bytes (or the size of an integer) containing the CPU requirements for the
program
Four bytes (or the size of an integer) containing the Memory requirements for the
Program

For createdirectory command: 
A filename must be entered and is the first part of the directory with an ending of .d

Next, the number of files/directories in the directory stored as an integer.
Next, the files stored in the directory and the sub-directories contained in the

directory (stored in the order entered by the user).

Enddir command will set the current working directory to be the previous working directory and
add 14 bytes to the binary filesystem (End followed by the 11 character filename).

quit will stop the application. When the application is stopped it prints out the location
in the filesystem for what was added by the user.