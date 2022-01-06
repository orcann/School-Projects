//package project2;
import java.lang.Math;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
/*
 * @author Christopher Lee
 * class file for our Points 
 * coordinate - > long x, long y
 */
public class Pairs {
	
	private long x; 
	private long y;
	
	public Pairs() {
		//empty constructor
	}
	public Pairs(long cx, long cy) {
		this.x = cx;
		this.y = cy;
	}
	
	public String toString() {
		return "(" + x + "," +y + ")";
	}
	
	//getters and setters
	public long getX() {
		return x;
	}
	public void setX(long x) {
		this.x = x;
	}
	public long getY() {
		return y;
	}
	public void setY(long y) {
		this.y = y;
	}
  /*Sortbyx Alist of points -> sorted list of points by x coordinates*/
	//it sorts the cordinate in the list according to cordinate x
		public static void sortByX(List<Pairs> points) {
		//Collections interface used for sorting the points
		Collections.sort(points, new Comparator < Pairs > () {
			public int compare(Pairs point1, Pairs point2) {
				if (point1.getX() < point2.getX())
					return -1;
				if (point1.getX() > point2.getX())
					return 1;
				return 0;
				}
			});
		}
	//follows same sigature as sortbyX except for Y values
		public static void sortByY(List<Pairs> points) {
			Collections.sort(points, new Comparator <Pairs> () {
				public int compare(Pairs point1, Pairs point2) {
					if (point1.getY() < point2.getY())
						return -1;
					if (point1.getY() > point2.getY())
						return 1;
					return 0;
					}
				});
			}

}

