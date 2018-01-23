package ch2_section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code03 {

	static Code01_Person1[] members;
	static int count = 0;
	
	public static void main(String[] args) {
		members  = new Code01_Person1[6];
		try {
			Scanner in = new Scanner(new File("number.txt"));
			
			while(in.hasNext()) {
				String name = in.next();
				String number = in.next();
				
				members[count] = new Code01_Person1();
				members[count].name = name;
				members[count].number = number;
				count++;
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("no file");
		}
		
		bubbleSort();
		
		for(int i=0; i<count; i++) {
			System.out.println(members[i].name+ " " + members[i].number);
		}
	}
	
	static void bubbleSort() {
		for(int i=count-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(members[j].name.compareTo(members[j+1].name) > 0) {
				
					Code01_Person1 tmp = members[j];
					members[j] = members[j+1];
					members[j+1] = tmp;
				}				
			}			
		}	
	}
}
