package ch4_section4_doubleLinkedList;

/*
<단방향 연결리스트의 한계>
단방향의 순회만이 가능,
어떤 노드 전에 새로운 노드를 삽입하기 어려움 --> 항상 어떤 노드 뒤에 삽입해야 함(addAfter는 있고 addBefore는 없었던 것 ㅇㅋ?)
삭제의 경우 역시 항상 삭제할 노드의 앞노드 주소가 필요.(removeAfter)

<이중 연결리스트 > 
각각의 노드가 다음노드와 이전노드의 주소를 가지는 연결로서 양방향의 순회가 가능하다.
*/

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	private static class Node<T> {
		public T data;
		public Node<T> next;
		public Node<T> prev;
		
		public Node(T item) {
			data = item;
			next = null;
		}
	}
	
	public Iterator<E> iterator() {
		return new MyListIterator(0);
	}
	
	public ListIterator<E> listIterator() {
		return new MyListIterator(0);
	}
	
	public ListIterator<E> listIterator(int index) {
		return new MyListIterator(index);
	}
	
	private class MyListIterator implements ListIterator<E> {
		private Node<E> nextItem; // 다음 노드를 참조 
		private Node<E> lastItemReturned;
		private int index;
		
		public MyListIterator(int i) {
			if(i<0 || i<size) {
				throw new IndexOutOfBoundsException();
			}
			lastItemReturned = null;
			if(i == size) {
				index = size;
				nextItem = null;
			} else {
				nextItem = head;
				for(index = 0; index<i; index++) {
					nextItem=nextItem.next;
				}
			}
		}
		
		@Override
		public boolean hasNext() {
			return nextItem != null;
		}

		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			lastItemReturned = nextItem;
			nextItem = nextItem.next;
			index++;
			return lastItemReturned.data;

		}

		@Override
		public boolean hasPrevious() {
			return (nextItem == null && size != 0) || nextItem.prev != null;
		}

		@Override
		public E previous() {
			if(!hasPrevious())
				throw new NoSuchElementException();
			if(nextItem == null)
				nextItem = tail;
			else
				nextItem = nextItem.prev;
			lastItemReturned = nextItem;
			index--;
			return lastItemReturned.data;
		}

		@Override
		public int nextIndex() {
			return index;
		}

		@Override
		public int previousIndex() {
			return index-1;
		}

		@Override
		public void remove() {
			
		}

		@Override
		public void set(E e) {
			
		}

		@Override
		public void add(E obj) {
			if(head == null) { // 아무것도 없는 상태에서 처음 노드를 추가할 때
				head = new Node<E>(obj);
				tail = head;
			} else if(nextItem == head) { // KMListIterator가 연결리스트 맨 앞에 있을 때
				Node<E> newNode = new Node<E>(obj);
				newNode.next = nextItem; // newNode.next = head; 와 동일한 의미.
				nextItem.prev = newNode;
				head = newNode;
				
			} else if(nextItem == null) { // KMListIterator가 맨 뒤에 있을 때
				Node<E> newNode = new Node<E>(obj);
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			} else {
				Node<E> newNode = new Node<E>(obj);
				newNode.prev = nextItem.prev;
				newNode.next = nextItem;
				nextItem.prev.next = newNode;
				nextItem.prev = newNode;
			}
			size++; index++;
		}
	}


	public int indexOf(E item) { //MysingleLinkedList와 동일함
		Node<E> p = head;
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
	
	public void add(int index, E item) {
		listIterator(index).add(item);
	}
	
	public E get(int index) {
		return listIterator(index).next();
	}
	
	public E remove(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		ListIterator<E> iter = listIterator(index);
		E result = iter.next();
		iter.remove();
		return result;
	}
	
	public boolean remove(E obj) {
		return true;
	}
	
	public int size() {
		return size;
	}
	
}
