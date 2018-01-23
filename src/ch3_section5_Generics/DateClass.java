package ch3_section5_Generics;

public class DateClass {
	public int year, month, day;
	
	public DateClass(int y, int m, int d) {
		year = y;
		month = m;
		day = d;
	}
	
	public int compareTo(DateClass other) {
		if(year > other.year || year == other.year && month > other.month
				|| year == other.year && month == other.month && day > other.day) {
			return 1;
		} else if(year < other.year || year == other.year && month < other.month
				|| year == other.year && month == other.month && day < other.day) {
			return -1;
		} else 
			return 0;
	}
	
	public String toString() {
		return year+ "/" + month+ "/"+ day;
	}
}
