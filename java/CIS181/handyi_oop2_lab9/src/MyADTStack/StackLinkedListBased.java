/*
 * Clinton Rogers (template) / Student: Ian Handy
 * Date: 2026-04-28
 * Lab9 — linked-list backed stack implementing StackInterface<T>.
 */

package MyADTStack;

public class StackLinkedListBased<T> implements StackInterface<T>{

	//linked list head point, no dummy node
	private Node<T> head = null;

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		//tis empty if the head is point to null
		return head == null;
	}

	public boolean isFull() {
		return false; //linked lists are never full
	}

	@Override
	public void popAll() {
		//make the linked list empty
		head = null;
	}

	@Override
	public void push(T newItem) throws StackException {

		//throw if the caller hands us null, matching StackArrayBased.push behavior
		if (newItem == null)
			throw new StackException("Stack Exception: null item pushed to stack, push not successful");

		// create a new node, and insert it at the beginning of the linked list.
		Node<T> newNode = new Node<T>();
		newNode.setData(newItem);
		newNode.setNext(head);
		head = newNode;
	}

	@Override
	public T pop() throws StackException {
		//throw if the stack is empty (popping nothing isn't valid)
		if (isEmpty())
			throw new StackException("Stack Exception: pop attempted on empty stack, pop not successful");

		//temporarily grab hold of the data with a temp pointer of type T
		T temp = head.getData();

		//Bypass the head pointer so it points to the second node in the list
		head = head.getNext();

		//return that temp pointer.
		return temp;
	}

	@Override
	public T peek() throws StackException {
		//throw if the stack is empty (peeking nothing isn't valid)
		if (isEmpty())
			throw new StackException("Stack Exception peek attempted on empty stack, peek not successful");

		//return the data at the beginning of the linked list/top of the stack
		return head.getData();
	}

}

class Node<E>
{
	private E data;
	private Node<E> next;

	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public Node<E> getNext() {
		return next;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}
}
