package ch3_section1_inheritance;
//다형성(Polymorphism): 슈퍼클래스 타입의 변수가 서브클래스 타입의 객체를 참조할 수 있다.
//변수의 타입과 그 변수에 저장되는 데이터의 타입이 같아야 한다는 Strong Typing 원칙의 예외.
public class Notebook extends Computer {
	
	private double screenSize;
	private double weight;
	
	public Notebook(String man, String proc, int ram, int disk, double speed, double screen, double weight) {
		super(man, proc, ram, disk, speed);
		screenSize = screen;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		String result = super.toString() +
						"\nScreen Size: " + screenSize + "inches" +
						"\nweight: "+weight +"kg";
		return result;
	}
	
	public static void main(String[] args) {
		Computer test = new Notebook("deli", "i5", 4, 1000, 3.2, 15.6, 1.2); // polymorphism!!!!
//		System.out.println(test.computerPower());
		System.out.println(test.toString()); // static binding(compiler) vs dynamic binding(run time)
	}
}
