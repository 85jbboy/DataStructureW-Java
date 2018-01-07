
package section3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyCode22 {
	
	static String[] wordList = new String[100000];
	static int TotalWordNum = 0;

	static String command = null;
	static String directObj = null;
	private static Scanner kb;
	public static void main(String[] args) {
		
		try {
			kb = new Scanner(System.in);
			while(true) {
				System.out.print("$ ");
				command = kb.next(); // 명령어를 인식
				
				if(command.equals("exit")) {
					System.out.println("Byebye~");
					break;
				} else if(command.equals("find")) {
					directObj = kb.next();	
					find(directObj);
				} else if(command.equals("read")) {
					directObj = kb.next();	
					read(directObj);
				} else if(command.equals("saveas")) {
					directObj = kb.next();	
	
				} else {
					System.out.println("The command you just input (" + command + ") does not exit");
				}

			}
			
		} catch(Exception e) {
			e.getMessage();
		}
	}
	
	static public void find(String word) {
		int wordNum = 0;
		for(int i=0; i<TotalWordNum; i++) {
			if(wordList[i].equalsIgnoreCase(word) 
					|| wordList[i].equalsIgnoreCase(word+",") 
					|| wordList[i].equalsIgnoreCase(word+".")) {
				wordNum++;
			}
		}
		if(wordNum != 0) {
			System.out.println("The word \""+ word + "\" appears " +wordNum+" times.");			
		} else {
			System.out.println("The word \""+ word + "\" does not appear.");
		}
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
	
	static public void saveas() {
		
		
	}
	
}
