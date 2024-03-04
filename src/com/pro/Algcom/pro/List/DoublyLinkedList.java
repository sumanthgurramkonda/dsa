package com.pro.Algcom.pro.List;

public class DoublyLinkedList<E> {
	private Node<E> head;
	private Node<E> curr;
	private int size=0;
	
	private class Node<E>{
		private E data;
		private Node<E> tail;
		private Node<E> next;
		public Node(E data) {
			this.data=data;
			this.next=null;
			this.tail=null;
		}
	}
	
	public void add(E data) {
		
		if(this.head==null) {
			this.head = new Node<E>(data);
			this.curr = this.head;
			size++;
			return;
		}
		this.curr.next = new Node<E>(data);
		this.curr.next.tail = this.curr;
		this.curr = this.curr.next;
		size++;
	}
	
	public void addFirst(E data) {
		if(this.head==null)add(data);
		else {
			Node<E> temp = new Node(data);
			this.head.tail=temp;
			temp.next=head;
			head=temp;	
		}
	}
	public E remove(int index) {
		if(index==0) {
			E data=head.data;
			head=head.next;
			head.tail=null;
			return data;
		}
		Node<E> temp = this.head;
		while(index>0) {
			temp=temp.next;
			index--;
		}
		temp.tail.next=temp.next;
		temp.next.tail=temp.tail;
		temp.next=null;
		temp.tail=null;
		size--;
		return temp.data;
	}
	
	@Override
	public String toString() {
		String data = "";
		Node<E> temp=head;
		while(temp!=null) {
			data+=temp.data+" ";
			temp=temp.next;
		}
		return data;
	}
	
	public static void main(String[] args) {
		
		DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();
		
		dl.add(10);
		dl.add(20);
		dl.add(30);
        dl.addFirst(9);
        dl.add(40);
		System.out.println(dl);
		System.out.println(dl.remove(0));
		System.out.println(dl);
	}
}









