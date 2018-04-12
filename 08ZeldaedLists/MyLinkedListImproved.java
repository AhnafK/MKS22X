import java.util.*;
public class MyLinkedListImproved<L extends Comparable<L>> implements Iterable<L>{

    public Literator iterator(){
	return new Literator(this);
    }
    
    private class Node{
	private Node prev;
	private Node next;
	private L data;

	private Node(){}
	
	private Node(Node l, Node n, L i){
	    prev = l;
	    next = n;
	    data = i;
	}
	
	private Node(Node n, L i){
	    next = n;
	    data = i;
	}

	private Node(L i, Node n){
	    prev = n;
	    data = i;
	}

	private Node getPrev(){
	    return prev;
	}

	private Node getNext(){
	    return next;
	}

	private L getValue(){
	    return data;
	}

	private L setValue(L i){
	    L ans = data;
	    data = i;
	    return ans;
	}
	
	private boolean setPrev(Node n){
	    prev = n;
	    return true;
	}

	private boolean setNext(Node n){
	    next = n;
	    return true;
	}
    }

    public class Literator implements Iterator<L>{
	Node current;
	MyLinkedListImproved<L> a;

	private Literator(MyLinkedListImproved<L> b){
	    a = b;
	    current = a.start;
	}
	
	public boolean hasNext(){
	    return  current.next != a.end;
	}

	public L next(){
	    current = current.next;
	    return current.getValue();
	}
    }
    private Node start;
    private Node end;
    private int size;

    public MyLinkedListImproved(){
	size = 0;
	start = new Node(null, end, null);
	end = new Node(start, null, null);
    }

    public boolean add(L value){
	Node neW = new Node(null, end, value);
	end.getPrev().setNext(neW);
	end.setPrev(neW);
	size += 1;
	return true;
    }

        public boolean add(int index, L value){
	if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
	if(index == size)
	    add(value);
	
	Node nextt = getNode(index);
	Node current = new Node (nextt.prev, nextt, value);
	//nextt.prev.next = current;
	getNode(index-1).setNext(current);
	nextt.prev = current;
	size += 1;
	return true;
    }
    
    public int size(){
	return size;
    }
    
    public String toString(){
	/*
	Node current = start.next;
	String ans = "[";
	while(current != end){
	    ans += " " + current.getValue() + ",";
	    current = current.getNext();
	}
	return ans + "]";
	*/

	String ans = "[";
	Iterator j = iterator();
	while(j.hasNext()){
	    ans += "" + j.next() + ", ";
	}
	return ans + "]";
    }

    private Node getNode(int index){
	if(index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	Node current = start.next;
	for(int x = 0; x < index; x ++){
	    current = current.getNext();
	}
	return current;
    }
    
    public L get(int index){
	return getNode(index).getValue();
    }

    public int indexOf(L value){
	Node current = start.getNext();
	int x = 0;
	while(current.getValue() != value){
	    x+=1;
	    current = current.getNext();
	}
	return x;
    }

    public void clear(){
	size = 0;
	start.setNext(end);
	end.setPrev(start);
    }

    public L set(int index, L value){
	Node current = getNode(index);
	return current.setValue(value);
    }

    public boolean remove(L value){
	Node current = getNode(indexOf(value));
	return current.getPrev().setNext(current.getNext()) &&
	    current.getNext().setPrev(current.getPrev());
    }

    public L remove(int index){
	Node current = getNode(index);
	current.getPrev().setNext(current.getNext());
	current.getNext().setPrev(current.getPrev());
	return current.getValue();
    }

    public int max(){
	if(size < 1)
	    return -1;
	int index = 0;
	int current = 1;
	Literator l = iterator();
	L max = l.next();
	while(l.hasNext()){
	    L now = l.next();
	    if(now.compareTo(max) > 0){
		index = current;
		max = now;
	    }
	    current ++;
	}
	return index;
    }

    public int min(){
	if(size < 1)
	    return -1;
	int index = 0;
	int current = 1;
	Literator l = iterator();
	L min = l.next();
	while(l.hasNext()){
	    L now = l.next();
	    if(now.compareTo(min) < 0){
		index = current;
		min = now;
	    }
	    current ++;
	}
	return index;
    }
    

    public static void main(String[]args){
	MyLinkedListImproved<Integer> data = new MyLinkedListImproved<>();
	
	data.add(4);
	data.add(5);
	data.add(6);
	System.out.println(data);
	data.set(1,100);
	System.out.println(""+data.get(1) + " " + data.indexOf(6) + " " + data.size() + " " + data.max());
	data.clear();
	System.out.println(data);

	MyLinkedListImproved<String> datb = new MyLinkedListImproved<>();
	
	datb.add("four");
	datb.add("five");
	datb.add("six");
	System.out.println(datb);
	datb.set(1,"hund");
	System.out.println(datb.get(1) + " " + datb.indexOf("six") + " " + datb.size());
	datb.clear();
	System.out.println(datb);
    }
}
