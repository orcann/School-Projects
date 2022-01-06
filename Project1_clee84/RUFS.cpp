/*Christopher Lee
2/22/21
Project 1
Professor Ray
Objective: The goal of this project is to simulate a file system that allows user to create files and directories and saves 
them to a binary file.

*/
#include "FileSystem.hpp"

std::string command;
std::string *argsPointer(new std::string);

//enumeration for each input string command will be used as a hash key
  enum string_code {
      cCreateDir, //maps to the create dir command
      cCreateFile, //createfile command
      cEndDir,//for enddir
      cquit, //for the quit 
    // make text will use later cMktxt,   
      cError
  };
  //hash function that takes in a string commad from input and returns an enum value
  string_code hashit (std::string const& inString) {
      if (inString == "CreateDir") return cCreateDir;
      if (inString == "CreateFile") return cCreateFile;
      if (inString == "EndDir") return cEndDir;
      if (inString == "quit") return cquit;
      else return cError; 
  }
//main function
int main(int argc, char** argv) {
  std::cout << "Welcome to RUFS.  Enter one of the following commands:\n";
  std::cout << "CreateDir or CreateFile or EndDir or quit\n";
  initialize(argv);
  //initialize(argv);
  bool open = true;
  while(open){
    //now take in the command
    std::cout << "Command>";
    getline(std::cin, command);
    std::cout<< command << std::endl;
    
    //break command into base command and string of the arguments
    //also a work around for extrenous whitespace
    std::size_t space=command.find(' ');
    if (space!=std::string::npos){ //found a space in the command
      argsPointer->assign(command.substr(space+1,command.length()));
      command = command.substr(0,space);
    }

    //Switch case for commands to function calls
    //i used a hash function to create a switch menu 
    switch(hashit(command)){
      case cCreateFile:
        createFile();
        break;
      case cCreateDir:
        createDir();
        break;
      case cEndDir:
        endDir();
        break;
      case cquit:
        quit();
        open = false;
        break;
        //error checking
      default:
        std::cout << ">" << command << ": command not found\n";
    }
  }
  return 0;
}