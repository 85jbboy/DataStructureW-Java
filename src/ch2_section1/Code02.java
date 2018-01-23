package ch2_section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code02 {

	static Code01_Person1[] members;
	static int n = 0;
	
	public static void main(String[] args) {
		members  = new Code01_Person1[6];
		try {
			Scanner in = new Scanner(new File("number.txt"));
			
			while(in.hasNext()) {
				String name = in.next();
				String number = in.next();
				
				members[n] = new Code01_Person1();
				members[n].name = name;
				members[n].number = number;
				n++;
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("no file");
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(members[i].name+ " " + members[i].number);
		}
	}

}
