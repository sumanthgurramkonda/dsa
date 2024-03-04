package com.pro.Algcom.pro.List;

public class LinkedList<E> {
	
	private Node<E> head;
	private Node<E> curr;	
	private int size=0;
	
	private class Node<T>{
		private T data;
		public Node<T> next;
		Node(T data){
	    	this.data=(T)data;
	    }
	}
	public void add(E data) {    
		if(this.head==null) {
			this.head = new Node<E>(data);
			this.curr=this.head;
			this.size++;
			return;
		}
		this.curr.next=new Node<E>(data);
		this.curr=this.curr.next;
		this.size++;
	}
	
	public boolean remove(Object o) {
		if(head.data.equals(o)) {
			head=head.next;
			this.size--;
			return true;
		}
		Node<E> temp=head;
		Node<E> prev = null; 
		while(temp!=null) {
			if(temp.data.equals(o)) {
				prev.next=temp.next;
				temp.next=null;
				this.size--;
				return true;
			}
			prev=temp;
			temp=temp.next;
		}
		return false;
		
	}
	public boolean addAll(LinkedList<E> ll) {
		if(ll.head!=null && this.head!=ll.head) {
			this.curr.next = ll.head;
			return true;
		}
		return false;
		
	}
	public void reverse() {
		
		Node<E> curr = this.head;
		Node<E> next = null;
		Node<E> prev=null;
		
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		this.head=prev;
		
	}
	
	
	public int size() {
		return this.size;
	}
	
	public boolean isEMpty() {
		return this.size==0;
	}
	
	@SuppressWarnings("unchecked")
	public boolean contains(Object data) {
		Node<E> temp=head;
		while(temp!=null) {
			if(temp.data.equals((E)data))return true;
			temp=temp.next;
		}
		return false;
	}
	
	@Override
	public String toString() {
		Node<E> curr=this.head;
		String data ="";
		while(curr!=null) {
			data+=curr.data+" ";
			curr=curr.next;
		}
		return data;
	}
	
	public LinkedList<E> mergeSortList(LinkedList<E> ll){
		
		Node<E> head1 = new Node<E>(null);
		Node<E> temp=head1;
		Node<E> n1 = this.head;
		Node<E> n2 = ll.head;
		while(n1!=null && n2!=null) {
			if((Integer)n1.data<(Integer)n2.data) {
				temp.next=n1;
				n1=n1.next;
			}
			else {
				temp.next=n2;
				n2=n2.next;
			}
			temp=temp.next;
		}
		if(n1==null)temp.next=n2;
		else temp.next=n2;
		LinkedList<E> l1 = new LinkedList<E>();
		l1.head=head1.next;
		return l1;
	}
	
	public LinkedList<Integer> addNumbers(LinkedList<Integer> list) {
		Node<E> a=this.head;
		@SuppressWarnings("rawtypes")
		Node b=list.head;
		LinkedList<Integer> dummy=new LinkedList<>();
		int carry = 0;
		while(a!=null || b!=null) {
			int x=(a!=null)?(int)a.data:0;
			int y=(b!=null)?(int)a.data:0;
			carry=(x+y)/10;
			dummy.add((x+y)%10);
			if(a!=null)a=a.next;
			if(b!=null)b=b.next;
		}
		if(carry>0)dummy.add(carry);
		return dummy;
		
	}
	public static void main(String[] args) {
		
		LinkedList<String> ll = new LinkedList<>();
		LinkedList<Integer> ll1 = new LinkedList<>();	
		LinkedList<Integer> ll2 = new LinkedList<>();
		LinkedList li = new LinkedList();
		li.add(10);
		li.add("Sumanth");
		li.add('c');
		li.add(2.3);
		System.out.println(li);
		ll.add("A");
		ll.add("B");
		ll.add("C");
		ll.add("D");
		ll.reverse();
//		System.out.println(ll);
//		System.out.println("Size = "+ll.size);
//		System.out.println(ll.contains("x"));
//		System.out.println(ll.remove("A"));
//		System.out.println(ll);
//		System.out.println(ll.addAll(ll));
		ll1.add(1);
		ll1.add(3);
		ll1.add(6);
		ll1.add(7);
		ll1.add(8);
		ll1.add(9);
//		System.out.println(ll1);
//		System.out.println(ll1.remove(1));
//		System.out.println("Size = "+ll1.size);
		ll2.add(2);
		ll2.add(4);
		ll2.add(5);
		ll2.add(10);
		ll1.mergeSortList(ll2);
		System.out.println(ll1);
		
		System.out.println(ll1.addNumbers(ll2));
		
		
		
		
		
	}
}
