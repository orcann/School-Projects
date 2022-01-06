@Author Christopher Lee
@ITEC 360 project 2 part 3
link https://www.radford.edu/~itec360/2021spring-ibarland/Homeworks/proj02/proj02.html
4/7/21
Closest pair problem
the purpose of this project is to run a program that will 
find the closest pairs of points in a text file 
using either a brute force alogorithm or divide and conquer
for part 1 only the brute force command is needed 
brute force will take O n^2 time
part 2 we now have the divide and conquer alogorithm working which will find the closest pair within O nlogn time
Part 3 we now have our divide and conquer completed

@Commands: 
Brute - outputs the information about the brute force closestpair 
Divide - outputs the information about the divide conquer cloestpair
Both - outputs both divide and brute

Test - currently not working must have junit library path installed.
 prints out unit tests info by calling the closesttest.java class

sample output 
closest brute < input4.txt
5 25 (0,0) (3,4) n=4 brute      0.001s

@Compile information 
you need to have a java compiler with jdk 8 or above
commands needed to compile "javac closes.java"
to run simply state the command brute or divide or both and test which will call the test class 
closest brute < input4.txt

