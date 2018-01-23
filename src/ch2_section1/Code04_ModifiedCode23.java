package ch2_section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Code04_ModifiedCode23 {

	
//	static String[] words = new String[100000];
//	static int[] count = new int[100000];
	
	static Code04_Item[] items = new Code04_Item[1000000];
	static int n = 0;
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		while(true) {
			System.out.print("$ ");
			String command = kb.next();
			
			if(command.equals("read")) {
				String filename = kb.next();
				makeIndex(filename);
				
			} else if(command.equals("find")) {
				String str = kb.next();
				int index = findWord(str);
				if(index > -1) {
					System.out.println("The word " + items[index].word + " appears " + items[index].count+ " times");
				} else {
					System.out.println("The word " + str + " does not appears");
				}
				
				
			} else if(command.equals("saveas")) {
				String filename = kb.next();
				saveAs(filename);
				
			} else if(command.equals("exit")) {
				break;
			}
		}
		kb.close();
	}

	static void saveAs(String filename) {
		PrintWriter outFile;
		try {
			outFile = new PrintWriter(new FileWriter(filename));
			for(int i=0; i<n; i++) {
				outFile.println(items[i].word + " " + items[i].count);
			}
			
			outFile.close();	
		} catch (IOException e) {
			System.out.println("Save failed.");
			return;
		}
	}

	static void makeIndex(String filename) {
		try {
			Scanner infile = new Scanner(new File(filename));
			while(infile.hasNext()) {
				String str = infile.next();
				
				String trimmed = trimming(str);
				if(trimmed != null) {
					
					addWord(trimmed);
				}
					
			}
			infile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("No File");
			return;
		}
	}

	static String trimming(String str) {
		if(str == null || str.length() <= 0) 
			return null;
		int i = 0, j = str.length() - 1;
		while(i < str.length() && !Character.isLetter(str.charAt(i))) {
			i++;
		}
		while(j >= 0 && !Character.isLetter(str.charAt(j))) {
			j--;
		}
		
		if(i > j) 
			return null;
		return str.substring(i, j+1);
	}

	static void addWord(String str) {
		int index = findWord(str); 
		if(index != -1) {        //exit
			items[index].count++;
		} else {                 //non-exist --> insert
			int i = n-1;
			while(i>=0 && items[i].word.compareToIgnoreCase(str)>0) {
				items[i+1] = items[i];
				i--;
			}
			items[i+1] = new Code04_Item();
			items[i+1].word = str;
			items[i+1].count = 1;
			n++;
		}
	}
	
	static int findWord(String str) {
		for(int i=0; i<n; i++) {
			if(items[i].word.equalsIgnoreCase(str)) {
				return i;
			}
		}
		return -1;
	}
}
