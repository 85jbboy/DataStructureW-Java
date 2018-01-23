package ch4_section2_Polynomial;

import ch4_section1_SingleLinkedList.MySingleLinkedList;
import ch4_section1_SingleLinkedList.Node;

public class Polynomial {
	
	public char name;
	public MySingleLinkedList<Term> terms;
	
	public Polynomial(char name) {
		this.name = name;
		terms = new MySingleLinkedList<Term>();
	}
	
	public void addTerm(int coef, int expo) {
		if(coef == 0) {
			return;
		}
		Node<Term> p = terms.head, q = null;
		
		while(p != null && p.data.expo > expo) {
			q = p;
			p = p.next;
		}
		if(p != null && p.data.expo == expo) {
			p.data.coef += coef;
			if(p.data.coef == 0) { // remove this Node.
				if( q == null) {
					terms.removeFirst();
				} else {
					terms.removeAfter(q);	
				}
			}
		} else {  // add after q
			Term t = new Term(coef, expo);
			if(q == null) {
				terms.addFirst(t);
			} else {
				terms.addAfter(q, t);		
			}
		}
	}

	public int calc(int x) {
		int result = 0;

		Node<Term> p = terms.head;
		while(p!=null) {
			result += p.data.calc(x);
			p = p.next;
		}
		return result;
		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name+"(x)=");
		Node<Term> p = terms.head;
		while(p!=null) {
			sb.append("+" + p.data.toString());
			p = p.next;
		}
		return sb.toString();
	}
}
