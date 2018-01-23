package ch2_section3;
// 하나의 항(Term)을 표현하기 위한 클래스

public class Term3 {
	private int coef;
	private int expo;

	public int getExpo() {
		return expo;
	}
	
	public void setCoef(int coef) {
		this.coef = coef;
	}
	
	public int getCoef() {
		return coef;
	}
	
	public Term3(int coef, int expo) {
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
