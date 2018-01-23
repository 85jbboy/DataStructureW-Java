package ch3_section5_Generics;

import java.util.Arrays;

// List 클래스
// 여러개 테이터를 저장, 임의 위치에 새로운 데이터 추가(삽입), 데이터 삭제, 임의의 위치의 데이터 읽기, 용량 제한 無

public class MyArrayList<E> {
	private static final int INIT_CAPACITY = 10;
	private E[] theData;
	private int size;
	private int capacity;
	
	
	public MyArrayList() {
		theData = (E []) new Object[INIT_CAPACITY];
		size = 0;
		capacity = INIT_CAPACITY;
	}
	
	public int size() {
		return size;
	}
	
	public void add(E anEntry) {
		add(size, anEntry);
	}
	
	public void add(int index, E anEntry) {
		if(index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		if(size >= capacity) {
			reallocate();
		}
		for(int i=size-1; i>=index; i--) {
			theData[i+1] = theData[i];
		}
		theData[index] = anEntry;
		size++;
	}
	
	private void reallocate() {
		capacity *= 2;
		theData = Arrays.copyOf(theData, capacity);
//		E[] tmp = (E []) new Object[capacity];
//		for(int i=0; i<size; i++) {
//			tmp[i] = theData[i];
//		}
//		theData = tmp;	
	}

	public E remove(int index) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E returnValue = theData[index];
		for(int i=index+1; i<size; i++) {
			theData[i-1] = theData[i];
		}
		size--;
		return returnValue;
	}
	
	public E set(int index, E newValue) { // 덮어쓰기
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E oldValue = theData[index]; //  옛 자료는 없어지기 전에 리턴해주기 위해서 일단 저장해둠.
		theData[index] = newValue;
		return oldValue;
	}
	
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return theData[index];
	}
	
	public int indexOf(E anEntry) {
		for(int i=0; i<size; i++) {
			if(theData[i].equals(anEntry)) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		MyArrayList<String> test = new MyArrayList<>();
		
		try {
			test.add(1, "hello");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("-------------");
		}
		System.out.println("-------------");
	}
}
