package ch3_section4_Abstract_Interface;

public class Triangle extends Shape {

	private int height;
	private int width;
	
	public Triangle(int width, int height) {
		this.height = height;
		this.width = width;
	}
	
	@Override
	public double computeArea() {
		area = height*width/2;
		return area;
	}

	@Override
	public double computePerimeter() {
		perimeter = height+width+Math.sqrt(height*height + width*width); 
		return perimeter;
	}
	public String toString() {
		return "Triangle: Width is "+width+", Height is "+height;
	}
}
