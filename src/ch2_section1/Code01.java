package ch2_section1;

public class Code01 {
	public static void main(String[] args) {
	
		Code01_Person1 first = new Code01_Person1();
		
		first.name = "John";
		first.number = "010-3280-0212";
		
		System.out.println("Name : " + first.name + ", Number :" + first.number);

		Code01_Person1[] members = new Code01_Person1[100];
		members[0] = first;
		members[1] = new Code01_Person1();
		members[1].name = "David";
		members[1].number = "010-3456-1287";
		
		System.out.println("Name : " + members[1].name + ", Number :" + members[1].number);
		
	}
}
