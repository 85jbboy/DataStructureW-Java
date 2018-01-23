package ch2_section2;

public class Code09_Rectangles2 {
	public Code09_MyPoint2 lu;
	public int width, height;
	
	public Code09_Rectangles2 (int x, int y, int w, int h) {
		lu = new Code09_MyPoint2(x, y);
		width = w;
		height = h;
	}
	
	public Code09_Rectangles2(Code09_MyPoint2 p, int w, int h) {  // 이게 쓰이진 않음. 뒤꺼랑 크게 다르지 않음.
		lu = p;
		width = w;
		height = h;
	}
	
	public int calcArea() {
		return width * height;
	}
	
	public String toString() {
		return "(x, y) = ("+ lu.x + ", " + lu.y + ") \n" + "(w, h) = ("+width + ", "+height+")\n";
	}
}
