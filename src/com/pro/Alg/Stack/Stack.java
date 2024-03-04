package com.pro.Alg.Stack;

public class Stack<E> {
	
	private Node<E> top;
	private int length;
	
	private class Node<E>{
		private Node<E> next;
		private E data;
		
	    public Node(E data){
			this.data = data;
			this.next=null;
		}
	}
	
	public void push(E data) {
		Node<E> temp = new Node<E>(data);
		temp.next = top;
		top=temp;
		length++;
	}
	public E pop() throws StackIndexOutofBoundsException {
		E data=null;
	    if(this.top==null) throw new StackIndexOutofBoundsException("Stack is Empty");
		data = top.data;
		top=top.next;
		length--;
		return data;
	}
	

}
