/*
 * Clinton Rogers (template) / Student: Ian Handy
 * Date: 2026-04-28
 * Lab9 — recognize strings in language L = { w$w' : w' = reverse(w), w has no $ }.
 */

import MyADTStack.*;

public class StringRecognizer {

	/**
	 * precondition: none
	 * @param s: input string for testing
	 * @return true is s is in the language L = {w$w': w is a possibly empty string of characters
	 * 			other than $, w' = reverse(w)}; otherwise return false.
	 */
	boolean recognizeString(String s, boolean arrayBasedStack){
		int index = 0;

		StackInterface<Character> myStack;

		if(arrayBasedStack)
		{
			myStack = new StackArrayBased<Character>();
		}else
		{
			myStack = new StackLinkedListBased<Character>();
		}


		//while we haven't hit the end of the string (there was no $ sign) and we haven't found the money sign
		while (index < s.length() && s.charAt(index) != '$') {
			//go ahead and push the character onto the stack
			myStack.push(s.charAt(index));
			index++;
		}

		//if the index and the length of the string are the same, that means there is no $?  return false now.
		if (index == s.length()) {
			return false;
		}

		//otherwise, we can advance beyond the money signed and compare the rest of the characters
		//one by one as we pop off the stack. (For loop probably useful here)
		index++; // skip past the $
		for (; index < s.length(); index++) {
			//return false if a condition arises where we know s is not in this language
			if (myStack.isEmpty()) {
				// w' is longer than w
				return false;
			}
			char popped = myStack.pop();
			if (popped != s.charAt(index)) {
				// mismatch — not a reversal
				return false;
			}
		}

		//if we made it this far, are there any other conditions that would signify s is no in the language?
		if (!myStack.isEmpty()) {
			// w was longer than w' (we ran out of input before draining the stack)
			return false;
		}

		//made it through all the checks without returning false, s must be in the language
		return true;
	}

}
