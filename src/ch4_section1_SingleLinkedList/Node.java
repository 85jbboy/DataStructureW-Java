package ch4_section1_SingleLinkedList;

public class Node<T> {
	public T data;
	public Node<T> next;
	
	public Node(T item) {
		data = item;
		next = null;
	}
}
