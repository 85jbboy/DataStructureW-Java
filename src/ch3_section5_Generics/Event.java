package ch3_section5_Generics;

public abstract class Event {
	public String title;
	
	public Event(String title) {
		this.title = title;
	}

	public String toString() {
		return "Title:" + title;
	}
	
	public abstract boolean isRelevant(DateClass date);

}
