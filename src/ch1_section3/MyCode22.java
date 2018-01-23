
package ch1_section3;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MyCode22 {
	
	static String[] wordList = new String[100000];
	static int TotalWordNum = 0;

	static String command = null;
	static String directObj = null;
	
	public static void main(String[] args) {
		
		try {
			
			Scanner kb = new Scanner(System.in);
			while(true) {
				System.out.print("$ ");
				command = kb.next(); // 명령어를 인식
				
				if(command.equals("exit")) {
					System.out.println("Byebye~");
					break;
				} else if(command.equals("find")) {
					directObj = kb.next();	
					int wordNum = find(directObj);

					if(wordNum != 0) {
						System.out.println("The word \""+ directObj + "\" appears " +wordNum+" times.");			
					} else {
						System.out.println("The word \""+ directObj + "\" does not appear.");
					}
					
					
				} else if(command.equals("read")) {
					directObj = kb.next();	
					read(directObj);
				} else if(command.equals("saveas")) {
					directObj = kb.next();	
					saveAs(directObj);
				} else {
					System.out.println("The command you just input (" + command + ") does not exit");
				}

			}
			kb.close();
			
		} catch(Exception e) {
			e.getMessage();
		}
	}
	
	static public int find(String word) {
		int wordNum = 0;
		for(int i=0; i<TotalWordNum; i++) {
			if(wordList[i].equalsIgnoreCase(word) 
					|| wordList[i].equalsIgnoreCase(word+",") 
					|| wordList[i].equalsIgnoreCase(word+".")
					|| wordList[i].equalsIgnoreCase(word+"!") ) {
				wordNum++;
			}
		}
		return wordNum;
	}
	
	static public void read(String directObj) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(directObj));
			while(sc.hasNext()) {
				wordList[TotalWordNum] = sc.next();
				TotalWordNum++;
			}		// --> 총 261개 단어가 들어있음을 확인함.
			System.out.println("\"" + directObj + "\"에는 총 "+TotalWordNum+"개의 단어가 존재합니다.");
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find \""+ directObj + "\"");
		}
	}
	
	static public void saveAs(String directObj) {
		PrintWriter outFile;
		try {
			outFile = new PrintWriter(new FileWriter(directObj));
			for (int i=0; i<TotalWordNum; i++) {
				outFile.println(wordList[i]+ " " +find(wordList[i]) +"개");
			}
			outFile.close();
		} catch (IOException e) {
			System.out.println("Fileout failed");
		}
		
		
	}
	
}
