package ch2_section2;

import java.util.Scanner;

public class Code07 {

	static Code07_Polynomial2[] polys = new Code07_Polynomial2[100];
	static int n = 0;                  // 현재 입력되어, 저장되어 있는 다항식의 개수
	
	public static void main(String[] args) {

		
		Scanner kb = new Scanner(System.in);
		while(true) {
			System.out.print("$ ");
			String command = kb.next();
			if(command.equals("create")) {
				char name = kb.next().charAt(0); // 약간 꼼수이긴 하지만 nextChar() 지원안되므로..!
				
//				Polynomial p = new Polynomial();
//				p.name = name;
//				p.nTerms = 0;
//				polys[n] = p;
//				n++;
				
				polys[n] = new Code07_Polynomial2();
				polys[n].name = name;
				polys[n].terms = new Code07_Term2[100];
				polys[n].nTerms = 0;
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

	private static int find(char name) {
		for(int i=0; i<n; i++) {
			if(polys[i].name == name) {
				return i;
			}
		}
		return -1;
	}
}
