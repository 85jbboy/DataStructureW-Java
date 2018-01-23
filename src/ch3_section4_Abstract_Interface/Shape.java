package ch3_section4_Abstract_Interface;

public abstract class Shape implements Comparable<Object> {
	
	public double area;
	public double perimeter;
	
	public abstract double computeArea();
	public abstract double computePerimeter();
	
	public int compareTo(Object other) {
		double myArea = computeArea();
		double urArea = ((Shape)other).computeArea();
		if(myArea < urArea) {
			return -1;
		} else if(myArea == urArea) {
			return 0;
		} else {
			return 1;
		}
	}
}
