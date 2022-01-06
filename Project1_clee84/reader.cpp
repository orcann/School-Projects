#include <fstream>
#include <iostream>
using namespace std;
int main(int argc, char** argv)
{      
     ifstream ifile;        
     ifile.open(argv[1], ios::binary | ios::in);
     streampos begin,end,pos;        
     begin= ifile.tellg();       
      ifile.seekg(0, ios::end);     
         end = ifile.tellg();        
         ifile.seekg(0, ios::beg); 
         int data;        
         ifile.read((char*)&data, sizeof(data));
         cout << data <<endl;
         return 0;
         }
