package ch3_section4_Abstract_Interface;

public class Rectangle extends Shape{
	
	private int height;
	private int width;
	
	public Rectangle(int width, int height) {
		this.height = height;
		this.width = width;
	}
	
	@Override
	public double computeArea() {
		area = height*width;
		return area;
	}
	@Override
	public double computePerimeter() {
		perimeter = 2*(height+width); 
		return perimeter;
		
	}
	
	public String toString() {
		return "Rectangle: Width is "+width+", Height is "+height;
	}
}
