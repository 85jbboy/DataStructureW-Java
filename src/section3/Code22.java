package section3;

import java.util.Scanner;

public class Code22 {

	static String[] words = new String[100000];
	static int[] count = new int [100000];
	static int n = 0;
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		while(true) {
			System.out.print("$ ");
			String command = kb.next();
			if(command.equals("read")) {
				
				
			} else if(command.equals("find")) {
				
			} else if(command.equals("saveas")) {
				
			} else if(command.equals("exit")) {
				break;
			}
			
			
		}
		kb.close();
		
		
	}
}
