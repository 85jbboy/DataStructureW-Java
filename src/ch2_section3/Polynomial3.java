package ch2_section3;

public class Polynomial3 {
	private char name;          // 다항식 이름
	private Term3[] terms;       // 각 항의 차수와 지수를 저장하는 Term 배열
	private int nTerms;         // 항의 총 개수
	
	public Polynomial3(char name) {
		this.name = name;
		nTerms = 0;
		terms = new Term3[100];	
	}
	
	public char getName() {
		return name;
	}
	
	public void addTerm(int coef, int expo) {
		int index = findTerm(expo);
		if(index != -1) {                // 같은 지수가 이미 존재하면 그냥 차수끼리 더해주면 됨.
			terms[index].setCoef(terms[index].getCoef() + coef); // 추가로 -5x^3 + 5x^3 라면 0이 되어버리는 경우 생각해볼 것
			
		} else {                         // 새로운 지수이면 insert!
			int i = nTerms - 1;
			while(i >= 0 && expo > terms[i].getExpo() ) {
				terms[i+1] = terms[i];
				i--;
			}
			terms[i+1] = new Term3(coef, expo);
			nTerms++;
		}	
	}

	private int findTerm(int expo) {
		for(int i=0; i < nTerms && terms[i].getExpo() >= expo; i++) {
			if( terms[i].getExpo() == expo ) {
				return i;
			}
		}
		return -1;
	}
	
	public int calcPolynomial(int x) {
		int result = 0;
		for(int i=0; i<nTerms; i++) {
			result += terms[i].calcTerm(x);
		}
		return result;
	}
	
	public void printPolynomial() {
		for(int i=0; i<nTerms; i++) {
			terms[i].printTerm();
			System.out.print(" + ");
		}
		System.out.println();
	}
	
}
