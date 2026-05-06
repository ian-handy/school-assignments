/*
 * Clinton Rogers
 * Basic Node class using generics.  E represents a placehold for a class, to be filled in upon creating an instance
 * Example: Node<String> head = new Node<String>();
 * When some programmer create and instance of node above in their class, the "E" in this class will be replace with String
 * For instance, private E data; will be virtually replaced with private String data.
 */
public class Node <E>{
	
	private Node next;
	private E data;
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public Node<E> getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

	

}
