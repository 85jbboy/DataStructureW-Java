package ch3_section5_Generics;

public class DurationEvent extends Event{
	
	public DateClass begin;
	public DateClass end;
	
	public DurationEvent(String title, DateClass begin, DateClass end) {
		super(title);
		this.begin = begin;
		this.end = end;
	}
	
	public boolean isRelevant(DateClass date) {
		return begin.compareTo(date) <= 0 && end.compareTo(date) >= 0;
	}
	
	public String toString() {
		return super.toString()+", "+begin.toString()+" ~ " + end.toString();
	}	
}
