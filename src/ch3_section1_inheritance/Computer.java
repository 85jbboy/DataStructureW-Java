package ch3_section1_inheritance;

public class Computer {
	
	protected String manufacturer;  // protected는 상속하는 자식클래스에서는 사용가능하다.
	protected String processor;
	protected int ramSize;
	protected int diskSize;
	protected double processorSpeed;
	
//	public Computer() {
//		
//	}

	public Computer(String man, String proc, int ram, int disk, double procSpeed) {
		manufacturer = man;
		processor = proc;
		ramSize = ram;
		diskSize = disk;
		processorSpeed = procSpeed;
	}

	public double computerPower() {
		return ramSize * processorSpeed;
	}
	
	public String manufacturer() {
		return manufacturer;
	}
	public String getProcessor() {
		return processor;
	}
	public double getRamSize() {
		return ramSize;
	}
	public int getDisSize() {
		return diskSize;
	}
	public double getProcessorSpeed() {
		return processorSpeed;
	}
	
	public String toString() {
		String result = "Manufacture: " + manufacturer +
						"\nCPU: " + processor + 
						"\nRam: " + ramSize + "megabytes" +
						"\nDisk: " + diskSize + "gigabytes" +
						"\nProcessor speed: " + processorSpeed + " gigahertz";
		return result;
		
	}
}
