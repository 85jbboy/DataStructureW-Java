package ch4_section3_Iterator;
import java.util.Iterator;

public class Polynomial {
	
	public char name;
	public MySingleLinkedList<Term> terms;
	
	public Polynomial(char name) {
		this.name = name;
		terms = new MySingleLinkedList<Term>();
	}
	

	public void addTerm(int coef, int expo) {
//		if(coef == 0) {
//			return;
//		}
//		Node<Term> p = terms.head, q = null;
//		
//		while(p != null && p.data.expo > expo) {
//			q = p;
//			p = p.next;
//		}
//		if(p != null && p.data.expo == expo) {
//			p.data.coef += coef;
//			if(p.data.coef == 0) { // remove this Node.
//				if( q == null) {
//					terms.removeFirst();
//				} else {
//					terms.removeAfter(q);	
//				}
//			}
//		} else {  // add after q
//			Term t = new Term(coef, expo);
//			if(q == null) {
//				terms.addFirst(t);
//			} else {
//				terms.addAfter(q, t);		
//			}
//		}
	}

	public int calc(int x) {
		int result = 0;

		Iterator<Term> iter = terms.iterator();
		while(iter.hasNext()) {
			Term t = iter.next();
			result += t.calc(x);
		}
		return result;
		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name+"(x)=");
		Iterator<Term> iter = terms.iterator();
		while(iter.hasNext()) {
			Term t = iter.next();
			sb.append("+" + t.toString());
		}
		return sb.toString();
	}
}
