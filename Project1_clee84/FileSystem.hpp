//Christopher Lee
//header file for the file system contains declartions of our file system methods and contains our blueprint structs 
//for our files and directiorirs
#include <string>
#include <vector>
#include <iostream>

//Data structure baseline for the filesystem
struct Name{
  char name[8];
  char ext;
};
struct Txt{
    Name name;
    int textLength;
    std::string text;
};
struct Program{
    Name name;
    int cpu;
    int mem;
};
struct Directory{
    Name name;
    int contents;
    std::vector<Txt*>texts;
    std::vector<Program*>programs;
    std::vector<Directory*>subFolders;
    Directory *parent;
};

//void initialize();
void initialize(char**);
void createFile();
void createDir();
void endDir();
void quit();