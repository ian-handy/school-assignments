/*
 * Clinton Rogers
 * Lab9
 */

package MyADTStack;

import java.util.*;

public class StackArrayBased<T> implements StackInterface<T> {
	final int MAX_STACK = 50;  // maximum size of stack
	private ArrayList<T> items;
	private int top;

	public StackArrayBased() {
		items = new ArrayList<T>(MAX_STACK);
		top = 0; 
	}  // end default constructor

	public boolean isEmpty() {
		return top == 0;
	}  // end isEmpty

	public boolean isFull() {
		return top == MAX_STACK;
	}  // end isFull

	public void push(T newItem) throws StackException {
		if(newItem == null)
			throw new StackException("Stack Exception: null item pushed to stack, push not successful");
		
		if (!isFull()) {
			items.add(top, newItem);
			top++;
		} 
		else {
			throw new StackException("StackException: push attempted on full stack, push not successful");
		}  // end if
	}  // end push

	public void popAll() {
		items = new ArrayList<T>(MAX_STACK);
		top = 0; 
		
	}  // end popAll

	public T pop() throws StackException {
		if (!isEmpty()) {
			return items.remove(--top);
		}
		else {
			throw new StackException("Stack Exception: pop attempted on empty stack, pop not successful");
		}  // end if
	}  // end pop

	public T peek() throws StackException {
		if (!isEmpty()) {
			return items.get(top-1);
		}
		else {
			throw new StackException("Stack Exception peek attempted on empty stack, peek not successful");
		}  // end if
	}  // end peek
}  // end StackArrayBased
