package ch2_section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code05 {

	static Code05_Rectangles[] rects;
	static int n = 0;
	
	public static void main(String[] args) {
		
		rects = new Code05_Rectangles[100];
		try {
			Scanner in = new Scanner(new File("data.txt"));
			while(in.hasNext()) {
				rects[n] = new Code05_Rectangles();
				rects[n].lu = new Code05_MyPoint();
				
				rects[n].lu.x = in.nextInt();
				rects[n].lu.y = in.nextInt();
				
				rects[n].width = in.nextInt();
				rects[n].height = in.nextInt();
				n++;
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("No File found");
			System.exit(1);
		}
		
		bubbleSort();
		for(int i=0; i<n; i++) {
			System.out.println(rects[i].lu.x + " "
					+ rects[i].lu.y + " "
					+ rects[i].width + " "
					+ rects[i].height);
		}
		
	}
	
	private static void bubbleSort() {
		for(int i=n-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(calcArea(rects[j]) > calcArea(rects[j+1])) {
					Code05_Rectangles tmp = rects[j];
					rects[j] = rects[j+1];
					rects[j+1] = tmp;
					
				}
			}
		}
	}
	
	public static int calcArea(Code05_Rectangles r) {
		return r.width * r.height;
	}

}
