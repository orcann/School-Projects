all: RUFS

RUFS: RUFS.cpp FShandler.cpp FileSystem.hpp
	clang++ -Wall -std=c++17 RUFS.cpp FShandler.cpp -Ofast -o RUFS

rucs: RUFS.cpp FShandler.cpp FileSystem.hpp
	clang++ -Wall RUFS.cpp FShandler.cpp -std=c++17 -stdlib=libc++ -Ofast -o RUFS

gcc: RUFS.cpp FShandler.cpp FileSystem.hpp
	g++ -o RUFS RUFS.cpp FShandler.cpp

clean:
	rm RUFS