package ch2_section2;

public class Code07_Polynomial2 {
	public char name;          // 다항식 이름
	public Code07_Term2[] terms;       // 각 항의 차수와 지수를 저장하는 Term 배열
	public int nTerms;         // 항의 총 개수
	
	public void addTerm(int coef, int expo) {
		int index = findTerm(expo);
		if(index != -1) {                // 같은 지수가 이미 존재하면 그냥 차수끼리 더해주면 됨.
			terms[index].coef += coef; // 추가로 -5x^3 + 5x^3 라면 0이 되어버리는 경우 생각해볼 것
			
		} else {                         // 새로운 지수이면 insert!
			int i = nTerms - 1;
			while(i >= 0 && expo > terms[i].expo ) {
				terms[i+1] = terms[i];
				i--;
			}
			terms[i+1] = new Code07_Term2();
			terms[i+1].coef = coef;
			terms[i+1].expo = expo;
			nTerms++;
		}	
	}

	public int findTerm(int expo) {
		for(int i=0; i < nTerms && terms[i].expo >= expo; i++) {
			if( terms[i].expo == expo ) {
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
