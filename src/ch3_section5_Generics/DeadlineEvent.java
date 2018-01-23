package ch3_section5_Generics;

public class DeadlineEvent extends Event{
	DateClass deadline;
	
	public DeadlineEvent(String t, DateClass date) {
		super(t);
		deadline = date;
	}
	
	public boolean isRelevant(DateClass date) {
		return deadline.compareTo(date) >= 0;
	}

	public String toString() {
		return super.toString() + ", "+ deadline.toString();
	}
}
