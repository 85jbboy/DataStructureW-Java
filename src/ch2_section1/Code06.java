package ch2_section1;

import java.util.Scanner;

public class Code06 {

	static Code06_Polynomial2[] polys = new Code06_Polynomial2[100];
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
				
				polys[n] = new Code06_Polynomial2();
				polys[n].name = name;
				polys[n].terms = new Code06_Term[100];
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
					addTerm(polys[index], coef, expo);
				}
				
			} else if(command.equals("calc")) {
				char name = kb.next().charAt(0);
				int index = find(name);
				if(index == -1) {
					System.out.println("No such polynomial exists. Create it first");
				} else {
					int x = kb.nextInt();
					int result = calcPolynomial(polys[index], x);
					System.out.println(result);
				}
				
				
			} else if(command.equals("print")) {
				char name = kb.next().charAt(0);
				int index = find(name);
				if(index == -1) {
					System.out.println("No such polynomial exists. Create it first");
				} else {
					printPolynomial(polys[index]);
					
					
				}
			} else if(command.equals("exit")) {
				break;
			}
			
		}
		kb.close();
	}

	private static int calcPolynomial(Code06_Polynomial2 p, int x) {
		int result = 0;
		for(int i=0; i<p.nTerms; i++) {
			result += calcTerm(p.terms[i], x);
		}
		return result;
	}

	private static int calcTerm(Code06_Term term, int x) {
		return (int) (term.coef * Math.pow(x, term.expo));
	}

	private static void printPolynomial(Code06_Polynomial2 p) {
		for(int i=0; i<p.nTerms; i++) {
			printTerm(p.terms[i]);
			System.out.print(" + ");
		}
		System.out.println();
	}

	private static void printTerm(Code06_Term term) {
		System.out.print(term.coef + "x^" + term.expo);
		
	}

	private static void addTerm(Code06_Polynomial2 p, int coef, int expo) {
		int index = findTerm(p, expo);
		if(index != -1) {                // 같은 지수가 이미 존재하면 그냥 차수끼리 더해주면 됨.
			p.terms[index].coef += coef; // 추가로 -5x^3 + 5x^3 라면 0이 되어버리는 경우 생각해볼 것
			
		} else {                         // 새로운 지수이면 insert!
			int i = p.nTerms - 1;
			while(i >= 0 && expo > p.terms[i].expo ) {
				p.terms[i+1] = p.terms[i];
				i--;
			}
			p.terms[i+1] = new Code06_Term();
			p.terms[i+1].coef = coef;
			p.terms[i+1].expo = expo;
			p.nTerms++;
		}	
	}

	private static int findTerm(Code06_Polynomial2 p, int expo) {
		for(int i=0; i < p.nTerms && p.terms[i].expo >= expo; i++) {
			if( p.terms[i].expo == expo ) {
				return i;
			}
		}
		return -1;
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
