package ch3_section4_Abstract_Interface;
import java.util.Arrays;
import java.util.Scanner;

public class ShapeApplication {
	
	private static final int INITIAL_CAPACITY= 10;
	private int capacity = INITIAL_CAPACITY;
	private Shape[] figures = new Shape[capacity];
	private int n = 0;
	private Scanner sc = new Scanner(System.in);
	public void processShape() {
		
		while(true) {
			System.out.print("$ ");
			String command = sc.next();
			if(command.equalsIgnoreCase("add")) {
				char shape = sc.next().charAt(0);
				if(shape=='R') {
					handleRectangle(sc.nextInt(), sc.nextInt());
					
				}  else if (shape=='T') {
					handleTriangle(sc.nextInt(), sc.nextInt());
					
				} else if(shape=='C') {
					handleCircle(sc.nextInt());
				}		
			} else if(command.equalsIgnoreCase("show")) {
				handleShow();
			} else if(command.equalsIgnoreCase("showdetail")) {
				handleDetail();
			} else if(command.equalsIgnoreCase("sort")) {
				Arrays.sort(figures, 0, n);
			} else if(command.equalsIgnoreCase("exit")){
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("옳지 않은 명령어입니다.");
			}
		}		
		sc.close();
	}
	
//	public void bubbleSort() {
//		for(int i=n-1; i>0; i--) {
//			for(int j=0; j<i; j++) {
//				if(figures[j].area > figures[j+1].area) {
//					Shape tmp = figures[j];
//					figures[j] = figures[j+1];
//					figures[j+1] = tmp;
//				}
//			}
//		}
//	}
	
//	private void bubbleSort(Comparable[] data, int size) {
//		for(int i=n-1; i>0; i--) {
//			for(int j=0; j<i; j++) {
//				if(data[j].compareTo(data[j+1]) > 0) {
//					Comparable tmp = data[j];
//					data[j] = data[j+1];
//					data[j+1] = tmp;
//				}
//			}
//		}
//	}

	public void handleShow() {
		for(int i=0; i<n; i++) {
			System.out.println((i+1)+". "+figures[i].toString());
		}
	}
	
	public void handleDetail() {
		for(int i=0; i<n; i++) {
			System.out.println((i+1)+". "+figures[i].toString()
					+ "\n  - The area is " + figures[i].area
					+ "\n  - The perimeter is " + figures[i].perimeter);
			
		}
		
	}
	
	public void addShape(Shape newFigure) {
		if(capacity == n) {
			reallocate();
		}
		figures[n++] = newFigure;
	}
	
	public void reallocate() {
		capacity *= 2;
		Shape[] tmp = new Shape[capacity];
		System.arraycopy(figures, 0, tmp, 0, figures.length);
//		for(int i=0; i<figures.length; i++) {
//			tmp[i] = figures[i];
//		}
		
		figures = tmp;
 	}
	
	private void handleCircle(int radius) {
		Circle circle = new Circle(radius);
		circle.computeArea();
		circle.computePerimeter();
		addShape(circle);
	}

	private void handleRectangle(int width, int height) {
		Rectangle rect = new Rectangle(width, height);
		rect.computeArea();
		rect.computePerimeter();
		addShape(rect);
	}
	
	private void handleTriangle(int width, int height) {
		Triangle tri = new Triangle(width, height);
		tri.computeArea();
		tri.computePerimeter();
		addShape(tri);
		
	}

	public static void main(String[] args) {
		ShapeApplication mc = new ShapeApplication();
		mc.processShape();
	}
	
}
