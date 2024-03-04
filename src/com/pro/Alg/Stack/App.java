package com.pro.Alg.Stack;

public class App {
	
	public static void main(String[] args) throws StackIndexOutofBoundsException {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(10);
		stack.push(11);
		stack.push(12);
		stack.push(13);
		stack.push(14);
		try {
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
		}catch (StackIndexOutofBoundsException e) {
			throw new StackIndexOutofBoundsException("Stack is empty");
		}
	    
		
		
	}

}
