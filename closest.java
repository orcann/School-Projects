/*
@Author Christopher Lee
@ITEC 360 project 2 part 1
link https://www.radford.edu/~itec360/2021spring-ibarland/Homeworks/proj02/proj02.html
4/7/21
Closest pair problem
the purpose of this project is to run a program that will
find the closest pairs of points in a text file
using either a brute force alogorithm or divide and conquer
for part 1 only the brute force command is needed*/
import java.io.*;
import java.util.*;
 
public class closest {

  static Scanner scan;
 
    public static void main(String[] args) {
      scan = new Scanner(System.in);//create scanner
		
      ArrayList<Pairs> p = new ArrayList<Pairs>();
      
      String command; //will hold our command string
      //check arguements by default first arg is the command else default is divide
      if (args.length > 0) {
                command = args[0]; //commands should be first input
                
            }
      else
        command = "divide";
    //try catch statements//debugging to find mistmatch input 
    try {
      //read through the input file 
      while (scan.hasNext()) {
        //debug output
            //System.out.println(scan.next());
            long x = scan.nextLong();//read first double x
            long y = scan.nextLong(); //read second double y
            p.add(new Pairs(x,y)); //add the new coordinate to arraylist
            
            }
      scan.close();
      
    }
    catch (InputMismatchException e) {
      String token = scan.next();
      throw new InputMismatchException("attempts to read a 'double' value from standard input, "
                      + "but the next token is \"" + token + "\"");
    }
    catch (NoSuchElementException e) {
      throw new NoSuchElementException("attempts to read a 'double' value from standard input, "
                      + "but no more tokens are available");
    }
    /*call menu 
    menu takes in command returns corresponding algorithm or both or calls test unit
    */
    menu(command,p);

      
}

/**@findmindBrute: ArrayList of Pairs ->Alist closest pair
returns the closest pairs of coordinates in a list of coordinates using a brute force algorithm 
time complexity big theta n*(n-1) =n^2 where n is the total number of coordinates 
*/
public static ArrayList<Pairs> findminBrute(List<Pairs> p){
  //create a new array list of pairs to store the closest 2 pairs
  ArrayList<Pairs> cp = new ArrayList<Pairs>();
  double distance, temp = calcDistance(p.get(0),p.get(1)); //will hold our tempoary distance to compare to the next
  cp.add(0, p.get(0)); //initialize closest pairs for now
  cp.add(1, p.get(1));

  //first loop through starting index until the last minus 1 = (n-1) * 
  for (int i = 0; i < p.size() - 1; i++) {
    Pairs point1 = p.get(i);//get the 1st pair 
    //inner loop through the next index j (n-1)*n  
    for (int j = i + 1; j < p.size(); j++) {
      Pairs point2 = p.get(j); //get 2nd pair
      distance = calcDistance(point1, point2);
      if (distance < temp){ //if new distance is less than previous or temp then set the new min distance
        temp = distance;
        cp.remove(0); //remove the previous pairs
        cp.remove(0);
        //add the new closest points
        cp.add(0, point1);
        cp.add(1, point2);
      }
      }//end inner
      } //end outer loop

  return cp;
  }
  /*Divide and Conquer algorithm here*/


  //calcDistance takes in two pairs of pairs and returns the distance between them
	//pair1, pair2 -> long distance = sqroot((x1-x2)^2+(y1-y2)^2)
	public static double calcDistance(Pairs p1, Pairs p2) {
		double d = Math.sqrt(Math.pow((p1.getX() - p2.getX()),2)+Math.pow((p1.getY()-p2.getY()),2));
		return d;
	}
  /*Menu: string command, alist pairs -> output algorithm 
  menu function is a if else tree that displays the output depending on the command arguements*/
  public static void menu(String command, ArrayList<Pairs> p){
    //display code if else tree depending on command
      if(command.equalsIgnoreCase("brute")){
        //will hold closest pairs 
        ArrayList<Pairs> cp = new ArrayList<Pairs>();
        final long startTime = System.nanoTime();// start time convert to secs

        cp = findminBrute(p); //call brute force
        //end time
        final long endTime = System.nanoTime();

        double elapsedTime = (endTime - startTime) / 1000000000.; //convert to seconds

        int ds = (int)(Math.pow(calcDistance(cp.get(0),cp.get(1)),2)); //distance squared ds convert to int
        double d = calcDistance(cp.get(0),cp.get(1));
        //sample out display 5.0 25 (0,0) (3,4) n=4 brute 0.001s
        //System.out.println(d + " " + ds +  " " +cp.get(0).toString()+ " " + cp.get(1).toString() + "n=" + p.size() + " " + command + " " + elapsedTime + "s\n");
        //time %9.3f %g for d
        System.out.printf("%g %d %s %s n=%d %s %9.3f s\n",d,ds,cp.get(0).toString(), cp.get(1).toString(),p.size(),command,elapsedTime);

        

      } //both default
      else if(command.equalsIgnoreCase("both")){
        //print out the brute first 
       ArrayList<Pairs> cp = new ArrayList<Pairs>();
        final long startTime = System.nanoTime();// start time convert to secs

        cp = findminBrute(p); //call brute force
        final long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1000000000; //convert to seconds

        int ds = (int)(Math.pow(calcDistance(cp.get(0),cp.get(1)),2)); //distance squared ds convert to int
        double d = calcDistance(cp.get(0),cp.get(1));
        //sample out display 5.0 25 (0,0) (3,4) n=4 brute 0.001s
        System.out.printf("%g %d %s %s n=%d brute %9.3f s\n",d,ds,cp.get(0).toString(), cp.get(1).toString(),p.size(),elapsedTime);

        //print out the divide algorithm
        //start timed
        final long startTimed = System.nanoTime();
        ArrayList<Pairs> cp2 = new ArrayList<Pairs>(); 
        cp2 = divideAndConquer(p);
        //end time
        final long endTimed = System.nanoTime();

        double elapsedTimed = (endTimed - startTimed) / 1000000000;
        double minDist = calcDistance(cp2.get(0), cp2.get(1));
        System.out.printf("%g %d %s %s n=%d divide %9.3f s\n",minDist,(int)Math.pow(minDist,2),cp2.get(0).toString(), cp2.get(1).toString(),p.size(),elapsedTimed);



      }
      //blank for now
      else if(command.equalsIgnoreCase("divide")){
    	  final long startTimed = System.nanoTime();
          ArrayList<Pairs> cp2 = new ArrayList<Pairs>(); 
          cp2 = divideAndConquer(p);
          final long endTimed = System.nanoTime();
          double elapsedTimed = (endTimed - startTimed) / 1000000000;

          double minDist = calcDistance(cp2.get(0), cp2.get(1));

          System.out.printf("%g %d %s %s n=%d %s %9.3f s\n",minDist,(int)Math.pow(minDist,2),cp2.get(0).toString(), cp2.get(1).toString(),p.size(),command,elapsedTimed);

      }
      //if you input command test then calls our test class
      else if(command.equalsIgnoreCase("test")){
        // closestTest.testAll();

      }

  }

  /**@findmindDivideAndConquer: ArrayLists of sorted pairs -> An array of closest pair
    returns the closest pairs of coordinates in a list of coordinates using a divide and conquer algorithm
  */
  public static ArrayList<Pairs> divideAndConquer(List<Pairs> points) {
	  //create a list of sorted points of x and y 
	  List<Pairs> listofSortedX = new ArrayList<Pairs> (points);
	  Pairs.sortByX(listofSortedX);
	  List<Pairs> listofSortedY = new ArrayList<Pairs> (points);
	  Pairs.sortByY(listofSortedY);
	  return divideAndConquer(listofSortedX, listofSortedY);
	  }
	  // divide and conquer real implementation
  private static ArrayList<Pairs> divideAndConquer(List<Pairs> listofSortedX, List<Pairs> listofSortedY) {
	  ArrayList<Pairs> cp = new ArrayList<Pairs>();//will use to hold our closest pairs and return
	  int coorSize = listofSortedX.size();
	  //if the index size of sorted x list is less than 3 faster return brute
	  if (coorSize <= 3)
		  return findminBrute(listofSortedX);
	  //shift the index bit integer by 1
	  int index = coorSize >>> 1;
    //the divide split into 2 sublist
    //create a sublist of left side of the sorted x strip
	  List<Pairs>leftOfCenter = listofSortedX.subList(0, index);
    //right side sublist of strip x
	  List<Pairs>rightOfCenter = listofSortedX.subList(index, coorSize);
    //create a temp list to store the left of center
	  List<Pairs>tempList= new ArrayList<>(leftOfCenter);
	  
    //sort the temp list by y 
    Pairs.sortByY(tempList);
    //divide 
	  ArrayList<Pairs> closestPair = divideAndConquer(leftOfCenter, tempList);

	  tempList.clear();
    //sort the right side
	  tempList.addAll(rightOfCenter);
	  Pairs.sortByY(tempList);
    //divide
	  ArrayList<Pairs> closestPairRight = divideAndConquer(rightOfCenter, tempList);
    
	  if (calcDistance(closestPairRight.get(0),closestPairRight.get(1)) < calcDistance(closestPair.get(0),closestPair.get(1)))
		  closestPair = closestPairRight;

	  tempList.clear();
    //temp variables to store distances
	  double shortestDistance = calcDistance(closestPair.get(0),closestPair.get(1));
	  double centerX = rightOfCenter.get(0).getX();
	  //iterate through the sorted y list 
	  for (Pairs point: listofSortedY)
		  if (Math.abs(centerX - point.getX()) < shortestDistance)
			  tempList.add(point);
	  //loop through the temp list using a nested loop 
	  for (int i=0; i<tempList.size()-1;i++) {
		  Pairs point1 = tempList.get(i);
		  for (int j=i+1;j<tempList.size();j++) {
			  Pairs point2 = tempList.get(j);
			  if ((point2.getY() - point1.getY()) >= shortestDistance)
				  break;
			  double distance = calcDistance(point1, point2);
			  if (distance < calcDistance(closestPair.get(0),closestPair.get(1))) {       
				  closestPair.add(0,point1);
				  closestPair.add(1,point2);
				  shortestDistance = distance;
				  }
	  }}
	  return closestPair;
	  }
}
