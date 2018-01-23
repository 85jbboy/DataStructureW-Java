package ch3_section2_Scheduler;

public class OnedayEvent extends Event{
	public DateClass date;
	
	public OnedayEvent (String title, DateClass date) {
		super(title);
		this.date= date;
	}
	
	public boolean isRelevant(DateClass date) {
		return this.date.compareTo(date) == 0;
	}
	
	public String toString() {
		return super.toString()+", " + date.toString();
	}

}
