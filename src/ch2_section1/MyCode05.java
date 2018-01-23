package ch2_section1;

public class MyCode05 {

	static final int NumOfRect = 5; 
	static Code05_MyRectangle[] rects;
	
	
	public static void main(String[] args) {
		rects = new Code05_MyRectangle[NumOfRect];
		
		for(int i = 0; i < NumOfRect; i++) {
			rects[i] = new Code05_MyRectangle();
			rects[i].setRectangle();
			rects[i].calcArea();
		}	
		bubbleSort();
		
		for(int i = 0; i < NumOfRect; i++) {
			System.out.println((i+1)+"번째로 큰 사각형의 넓이: "+ rects[i].calcArea());
		}
	}	
	
	static public void bubbleSort() { // call by value
		for(int i=NumOfRect-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(rects[j].calcArea() > rects[j+1].calcArea()) {
					Code05_MyRectangle tmp = rects[j];
					rects[j] = rects[j+1];
					rects[j+1] = tmp;
				}
			}
		}
	}
	
	
	
	
}
