import java.util.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/*
@author Christopher Lee
ITEC 360 project 2 closest pair unit test
4/5/21
*/
public class ClosestTest {


//unit test to test brute force algorithm checking the distance value and size of the closest pair arraylist
  @Test
  public void testBrute() {
    closest close = new closest();
    ArrayList<Pairs> p = new ArrayList<Pairs>();
    p = this.constructPairs1();
    ArrayList<Pairs> cp = close.findminBrute(p);
    int d = (int)close.calcDistance(cp.get(0),cp.get(1));
    assertEquals(d, 5);
  //  assertEquals(cp.get(0),new Pairs(0,0)); //testing if first index value
    assertEquals(cp.size(),2); //the size should always be at most 2
    
   
    //test different list
    ArrayList<Pairs> p2 = new ArrayList<Pairs>();
    p2= this.constructPairs2();  
    ArrayList<Pairs> cp2 = close.findminBrute(p2);
    d = (int)close.calcDistance(cp2.get(0),cp2.get(1));
  //  assertEquals(cp2.get(0),new Pairs(0,0)); //testing if first index value
    assertEquals(cp2.size(),2); //the size should always be at most 2
    assertEquals(d, 1);
    //not too sure how many test cases I can actually make for the brute force algorithm  
   //since all thats being done is finding the distance
    
  }
  @Test
  public void testDivide() {
	  //closest close = new closest();
	  ArrayList<Pairs> p3 = new ArrayList<Pairs>();
	  p3= this.constructPairs3(); 
	  List<Pairs> sortedByX = new ArrayList<>(p3);
      List<Pairs> sortedByY = new ArrayList<>(p3);
      Pairs.sortByX(sortedByX);
      Pairs.sortByY(sortedByY);
      ArrayList<Pairs> cp2 = new ArrayList<Pairs>(); 
      cp2 = closest.divideAndConquer(p3);
     
 

      double minDist = closest.calcDistance(cp2.get(0), cp2.get(1));


     // ArrayList pair = closest.findMinDivideAndConquer(sortedByX, sortedByY);
     // double minDist = closest.calcDistance(pair[0], pair[1]);
      
      
      //test to check the sorted x points
      assertEquals(sortedByX.get(0).getX(),0); //new list should be 0 0 ,1 4 ,2 3 , 3 4 , 23 10
	  assertEquals(sortedByX.get(1).getX(),1);
	  assertEquals(sortedByX.get(2).getX(),2);
	  //test to check the sorted y points
	  assertEquals(sortedByY.get(0).getY(),0); //new list should be 0 0, 2 3, 3 4, 1 4, 23 10
	  assertEquals(sortedByY.get(1).getY(),3);
	  assertEquals(sortedByY.get(2).getY(),4);
	  assertEquals(sortedByY.get(3).getY(),4);
	  
	  //check the distance 
	  assertEquals(minDist,1.40,4);
	  
      
	    
	    
  }
  //function test to check if the sorting for x values work
  //list of pairs -> sorted list of pairs according to x values
  @Test
  public void testSortx() {
	  //initialize the pairs p1
	  ArrayList<Pairs> p3 = new ArrayList<Pairs>();
	    p3= this.constructPairs3(); 
	    //the unsorted list of pairs is 23 10, 0 0, 3 4, 1 4, 2,3
	    Pairs.sortByX(p3); //call the sort 
	    assertEquals(p3.get(0).getX(),0); //new list should be 0 0 ,1 4 ,2 3 , 3 4 , 23 10
	    assertEquals(p3.get(1).getX(),1);
	    assertEquals(p3.get(2).getX(),2);
	    assertEquals(p3.get(3).getX(),3);
	    assertEquals(p3.get(4).getX(),23);
  }
  //function test to check if the sorting for y values work
  //list of pairs -> sorted list of pairs according to y values
  @Test
  public void testSorty() {
	  //initialize the pairs p1
	  ArrayList<Pairs> p3 = new ArrayList<Pairs>();
	    p3= this.constructPairs3(); 
	    //the unsorted list of pairs is 23 10, 0 0, 3 4, 1 4, 2,3
	    Pairs.sortByY(p3); //call the sort 
	    assertEquals(p3.get(0).getY(),0); //new list should be 0 0, 2 3, 3 4, 1 4, 23 10
	    assertEquals(p3.get(1).getY(),3);
	    assertEquals(p3.get(2).getY(),4);
	    assertEquals(p3.get(3).getY(),4);
	    assertEquals(p3.get(4).getY(),10);
  }

//prime pairs data set 1
  private ArrayList<Pairs> constructPairs1() {
    ArrayList<Pairs> cp = new ArrayList<Pairs>();
    Pairs p1 = new Pairs(00,10);
    Pairs p2 = new Pairs(0,0);
    Pairs p3 = new Pairs(3,4);
    cp.add(p1);
    cp.add(p2);
    cp.add(p3);
    return cp;
  }
  private ArrayList<Pairs> constructPairs2() {
	    ArrayList<Pairs> cp = new ArrayList<Pairs>();
	    Pairs p1 = new Pairs(0,10);
	    Pairs p2 = new Pairs(0,0);
	    Pairs p3 = new Pairs(5,4);
	    Pairs p4 = new Pairs(1,1);
	    cp.add(p1);
	    cp.add(p2);
	    cp.add(p3);
	    cp.add(p4);
	    return cp;
	  }
//prime pairs data set 1
  private ArrayList<Pairs> constructPairs3() {
    ArrayList<Pairs> cp = new ArrayList<Pairs>();
    Pairs p1 = new Pairs(23,10);
    Pairs p2 = new Pairs(0,0);
    Pairs p3 = new Pairs(3,4);
    Pairs p4 = new Pairs(1,4);
    Pairs p5 = new Pairs(2,3);
    cp.add(p1);
    cp.add(p2);
    cp.add(p3);
    cp.add(p4);
    cp.add(p5);
    return cp;
  }
  //output test all complete 
  public static void testAll( boolean verbose ) {
      
      if (verbose) System.err.printf("(tests complete)\n"); 
      }
  public static void testAll() { testAll(false); }
  
  
}
