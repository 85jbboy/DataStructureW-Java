package ch2_section2;
// 하나의 항(Term)을 표현하기 위한 클래스

public class Code08_Term2 {
	public int coef;
	public int expo;

	public Code08_Term2(int coef, int expo) {
		this.coef = coef;
		this.expo = expo;
		
	}
	public int calcTerm(int x) {
		return (int) (coef * Math.pow(x, expo));
	}

	public void printTerm() {
		System.out.print(coef + "x^" + expo);
	}
}
