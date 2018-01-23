package ch3_section3_Object_Wrapper;

public class Test {
	public int a = 10;
	public double x =  5.67f;
	
	public String toString() {
		
		return a + ", " + x;
	}
	
	public boolean equals(Object other) {
		Test test3 = (Test) other;
		return a==test3.a && x == test3.x;
	}
	public static void main(String[] args) {
		
		Test test1 = new Test();
		Test test2 = new Test();
	
		if(test1.equals(test2)) {
			System.out.println("yes");
		
		} else
			System.out.println("no");
	}
}
