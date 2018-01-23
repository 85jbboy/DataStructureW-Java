package ch2_section3;

import java.util.Scanner;

public class Code11 {

	private Polynomial3[] polys = new Polynomial3[100];
	private int n = 0;                  // 현재 입력되어, 저장되어 있는 다항식의 개수
	
	public void processCommand() {
		Scanner kb = new Scanner(System.in);
		while(true) {
			System.out.print("$ ");
			String command = kb.next();
			if(command.equals("create")) {
				char name = kb.next().charAt(0); // 약간 꼼수이긴 하지만 nextChar() 지원안되므로..!
				polys[n] = new Polynomial3(name);
				n++;
				
			} else if(command.equals("add")) {
				char name = kb.next().charAt(0);
				int index = find(name);
				if(index == -1) {
					System.out.println("No such polynomial exists. Create it first");
				} else {
					int coef = kb.nextInt();
					int expo = kb.nextInt();
					polys[index].addTerm(coef, expo);
				}
				
			} else if(command.equals("calc")) {
				char name = kb.next().charAt(0);
				int index = find(name);
				if(index == -1) {
					System.out.println("No such polynomial exists. Create it first");
				} else {
					int x = kb.nextInt();
					int result = polys[index].calcPolynomial(x);
					System.out.println(result);
				}
				
				
			} else if(command.equals("print")) {
				char name = kb.next().charAt(0);
				int index = find(name);
				if(index == -1) {
					System.out.println("No such polynomial exists. Create it first");
				} else {
					polys[index].printPolynomial();					
				}
			} else if(command.equals("exit")) {
				break;
			}
		}
		kb.close();
	}
	
	private int find(char name) {
		for(int i=0; i<n; i++) {
			if(polys[i].getName() == name) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Code11 app = new Code11();
		app.processCommand();
	}
}
