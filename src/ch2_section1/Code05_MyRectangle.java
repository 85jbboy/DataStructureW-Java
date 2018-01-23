package ch2_section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code05_MyRectangle {
	
	int x, y, width, height;
	int area;
	
	public int calcArea() {	
		area = width * height;
		return area;
	}
	
	public void setRectangle() {
//		Scanner sc = new Scanner(System.in);
//			System.out.print("사격형의 x 좌표입력: ");
//			x = sc.nextInt();
//			
//			System.out.print("사격형의 y 좌표입력: ");
//			y = sc.nextInt();
//			
//			System.out.print("사격형의 너비입력: ");
//			width = sc.nextInt();
//			
//			System.out.print("사격형의 높이입력: ");
//			height = sc.nextInt();
		
		try {
			Scanner in = new Scanner(new File("data.txt"));
			x = in.nextInt();
			y = in.nextInt();
			width = in.nextInt();
			height = in.nextInt();
			
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Can't Find the File");
		}
	}
}

