package ch4_section1_SingleLinkedList;
// 연결리스트 다루는 프로그래밍에서 가장 주의해야 할 점은 '특수한 경우'에도 코드수행에 문제가 없는지를 항상 염두에 둬야 한다는 것이다.
// 예를 들어 애초에 노드가 전혀 없는 경우부터 시작한다고 할 때 (head가 null일 때) 에도 문제가 없는지 확인해봐야 한다.
public class MySingleLinkedList<T> {
	
	public Node<T> head;
	public int nodeSize;
	
	public MySingleLinkedList() {
		head = null;
		nodeSize = 0;
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
	public void addAfter(Node<T> before, T item) {
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
			return ;
		}
		if(index == 0) {
			addFirst(item);
		} else {
			Node<T> q = getNode(index-1);
			addAfter(q, item);
			
		}
	}
	
// 삭제하는 메소드이므로 아무것도 리턴하지 않아도 무관하긴 하지만 삭제대상의 데이터를 반환하는 것으로 작성.	
	public T removeFirst() {
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
	public T removeAfter(Node<T> before) {
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
			return null;
		} else if(index == 0) {
			return removeFirst();
		}
		Node<T> prev = getNode(index-1);
		return removeAfter(prev);
	}

	public T remove(T item) {
		Node<T> p = head, q = null;
		while(p!=null && !p.data.equals(item)) {
			q = p;
			p = p.next;
		}
		if(p==null) {
			return null;
		}
		if(q==null) {
			return removeFirst();
		} else {
			return removeAfter(q);
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
	
	public Node<T> getNode(int index) {  // 인덱스 번째 노드 주소 반환
		if(index < 0 || index >= nodeSize) {
			return null;
		}
		Node<T> p = head;
		for(int i=0; i<index; i++) {
			p = p.next;
		}
		return p;
	}
	
	public static void main(String[] args) {
		MySingleLinkedList<String> list = new MySingleLinkedList<>();
		list.addFirst("monday");
		list.addFirst("sunday");
	}

}
