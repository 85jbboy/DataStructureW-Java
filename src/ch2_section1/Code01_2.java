package ch2_section1;

public class Code01_2 {

	public static void main(String[] args) {

		Code01_Person1 first = new Code01_Person1();
		first.name = "John";
		first.number = "No.1";
		
		Code01_Person1 second = first;
		second.name = "Tom";
		
		System.out.println(first.name + ", " + first.number);
		
		Code01_Person1[] members = new Code01_Person1[5];
		members[0] = first;
		members[1] = second;
		
		System.out.println(members[0].name + ", "+ members[0].number);
		System.out.println(members[1].name + ", "+ members[1].number);
	}

}
