package ch4_section3_Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

// 연결리스트 다루는 프로그래밍에서 가장 주의해야 할 점은 '특수한 경우'에도 코드수행에 문제가 없는지를 항상 염두에 둬야 한다는 것이다.
// 예를 들어 애초에 노드가 전혀 없는 경우부터 시작한다고 할 때 (head가 null일 때) 에도 문제가 없는지 확인해봐야 한다.

public class MySingleLinkedList<T> {
	
	private Node<T> head;
	private int nodeSize;
	
	public MySingleLinkedList() {
		head = null;
		nodeSize = 0;
	}
	
// inner class --> 대부분의 경우 private으로 선언.
// inner class 내부에서 외부 클래스의 non static member들에 접근할 일이 없으면 static으로 선언하는 게 간명하다. 
	private static class Node<T> {
		public T data;
		public Node<T> next;
		
		public Node(T item) {
			data = item;
			next = null;
		}
	}

	public Iterator<T> iterator() {
		return new MyIterator();
	}
	
// inner class 안에서 외부 클래스의 non static member인 head에 액세스하므로 static으로 선언하지 않는다.	
	private class MyIterator implements Iterator<T> {
		private Node<T> nextNode;
		
		public MyIterator() {
			nextNode = head;
		}
		
		public boolean hasNext() {
			return nextNode != null;
		}
		
		public T next() {
			if(nextNode == null) {
				throw new NoSuchElementException();
			}
			T val = nextNode.data;
			nextNode = nextNode.next;
			return val;
		}
		
		public void remove() {
			
		}
	}
	
	public void addFirst(T item) {
//		T newNode = new T();                // not allowed(type parameter만을 자료형으로 하는 객체생성no) 
//		Node<T>[] arr = new Node<T>[100];   // not allowed
		
		Node<T> newNode = new Node<T>(item);     // T: type parameter
		newNode.next = head;
		head = newNode;
		nodeSize++;
	}
	
// 어떤 노드의 뒤에 삽입하는 것은 아래처럼 간단하지만, 반대로 어떤 노드의 앞에 삽입하는 것은 간단하지 않다.	
	private void addAfter(Node<T> before, T item) {
		Node<T> temp = new Node<T>(item);
		temp.next = before.next;
		before.next = temp;
		nodeSize++;
	}
	
//	public void add(T item) {
//		Node<T> addNode = new Node<T>(item);
//		addNode.next = null;
//		
//		nodeSize++;
//	}
	
	public void add(int index, T item) {
		if(index > 0 || index > nodeSize) {
			throw new IndexOutOfBoundsException();
		}
		if(index == 0) {
			addFirst(item);
			nodeSize++;
		} else {
			Node<T> q = getNode(index-1);
			addAfter(q, item);
			nodeSize++;
		}
	}
	
// 삭제하는 메소드이므로 아무것도 리턴하지 않아도 무관하긴 하지만 삭제대상의 데이터를 반환하는 것으로 작성.	
	private T removeFirst() {
		if(head == null) {
			return null;
		} else {
			T temp = head.data;
			head = head.next;
			nodeSize--;
			return temp;
		}
	}
// 어떤 노드를 삭제하고 싶으면 그 노드 '바로 앞 노드 주소'가 필요하다.
	private T removeAfter(Node<T> before) {
		if(before.next == null) {
			return null;
		} else {
			T temp = before.next.data;
			before.next = before.next.next;
			nodeSize--;
			return temp;	
		}
	}
	
	public T remove(int index) {
		if(index < 0 || index >= nodeSize) {
			throw new IndexOutOfBoundsException();
		} else if(index == 0) {
			return removeFirst();
		}
		Node<T> prev = getNode(index-1);
		return removeAfter(prev);
	}

	public boolean remove(T item) {
		Node<T> p = head, q = null;
		while(p!=null && !p.data.equals(item)) {
			q = p;
			p = p.next;
		}
		if(p==null) {
			return false;
		}
		if(q==null) {
			removeFirst();
			return true;
			
		} else {
			removeAfter(q);
			return true;
		}		
	}
// Traversing a Linked List.
	public int indexOf(T item) {
		Node<T> p = head;
		int index = 0;
		while(p != null) {
			if(p.data.equals(item)) {
				return index;
			}
			p = p.next;
			index++;
		}
		return -1;
	}
	
	public T get (int index) {           //인덱스 번째 데이터 번환
		if(index <0 || index >= nodeSize) {
			return null;
		}
		return getNode(index).data;
	}
	
	private Node<T> getNode(int index) {  // 인덱스 번째 노드 주소 반환
		if(index < 0 || index >= nodeSize) {
			return null;
		}
		Node<T> p = head;
		for(int i=0; i<index; i++) {
			p = p.next;
		}
		return p;
	}
	
	public int size() {
		return nodeSize;
	}
	public static void main(String[] args) {
		MySingleLinkedList<String> list = new MySingleLinkedList<>();
		list.addFirst("monday");
		list.addFirst("sunday");
	}

}
