package ch3_section4_Abstract_Interface;

public class Circle extends Shape{
	
	public static final double PI = 3.14;
	public int radius;
	
	public Circle(int radius) {
		this.radius = radius;
	}
	
	@Override
	public double computeArea() {
		area = PI*Math.pow(radius, 2);
		return area;
	}
	
	@Override
	public double computePerimeter() {
		perimeter = 2*PI*radius; 
		return perimeter;
	}
	
	public String toString() {
		return "Circle: radius is "+radius;
	}
}
