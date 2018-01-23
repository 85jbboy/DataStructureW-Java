package ch3_section5_Generics;

import java.util.ArrayList;
import java.util.Scanner;

public class Scheduler {
//	private int capacity = 10;
	public ArrayList<Event> scheduler = new ArrayList<>();
//	public Event[] scheduler = new Event[capacity]; // 1 : 多 상속관계 ---> 다형성!!!!! 
//	public int n;
	private Scanner kb;
	
	public void processCommand() {
		kb = new Scanner(System.in);
		while(true) {
			System.out.print("$ ");
			String command = kb.next();
			if(command.equals("addevent")) {
				 String type = kb.next();
				 if(type.equalsIgnoreCase("oneday")) {
					 handleAddOneDayEvent();
					 
				 }else if(type.equalsIgnoreCase("duration")) {
					 handleAddDurationEvent();
					 
				 }else if(type.equalsIgnoreCase("deadline")) {
					 handleAddDeadlinedEvent();		 
				 }
					
			} else if(command.equals("list")) {
				handleList();
				
			} else if(command.equals("show")) {
				handleShow();
				
			} else if(command.equals("exit")) {
				break;
			}
		}
		kb.close();
	}
	
	public void handleShow() {
		String date = kb.next();
		DateClass myDate = parseDateString(date); 
		
		for(Event ev : scheduler) {
			if(ev.isRelevant(myDate))	{
				System.out.println("  "+ ev.toString());
			}
		}
	}
	
	public void handleList() {
		for(Event ev : scheduler) {
			System.out.println("  "+ ev.toString());
		}
	}
	
	public void handleAddOneDayEvent() {
		System.out.print("  when: ");
		String dateString = kb.next(); // dataString = "2018/6/15"
		System.out.print("  title: ");
		String title = kb.next();
		
		DateClass date = parseDateString(dateString);
		Event ev = new OnedayEvent(title, date);
		
		addEvent(ev);
	}
	
	private void addEvent(Event ev) {
//		if(capacity == n) {
//			reallocate();
//		}
		scheduler.add(ev);
	}

//	private void reallocate() {		
//		capacity *= 2;
//		Event[] tmp = new Event[capacity];
//		for(int i=0; i<n; i++) {
//			tmp[i] = scheduler[i];
//		}
//		scheduler = tmp;
//	}

	public DateClass parseDateString(String date) {
		String[] tokens = date.split("/");
		int year = Integer.parseInt(tokens[0]);
		int month = Integer.parseInt(tokens[1]);
		int day = Integer.parseInt(tokens[2]);
		
		return new DateClass(year, month, day);
	}
	
	public void handleAddDurationEvent() {
		System.out.print("  begin: ");
		String begin = kb.next();
		System.out.print("  end: ");
		String end = kb.next();
		System.out.print("  title: ");
		String title = kb.next();
		
		DateClass beginDate = parseDateString(begin);
		DateClass endDate = parseDateString(end);
		
		Event ev = new DurationEvent(title, beginDate, endDate);
		addEvent(ev);
	}
	
	public void handleAddDeadlinedEvent() {
		System.out.print("  until: ");
		String until = kb.next();
		System.out.print("  title: ");
		String title = kb.next();
		
		DateClass untilDate = parseDateString(until);
		
		Event ev = new DeadlineEvent(title, untilDate);
		addEvent(ev);	
	}
	
	public static void main(String[] args) {

		Scheduler app = new Scheduler();
		app.processCommand();
	}
}
