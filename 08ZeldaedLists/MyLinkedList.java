public  class MyLinkedList{
    private class Node{
	private Node prev;
	private Node next;
	private Integer data;

	private Node(){}
	
	private Node(Node l, Node n, Integer i){
	    prev = l;
	    next = n;
	    data = i;
	}
	
	private Node(Node n, Integer i){
	    next = n;
	    data = i;
	}

	private Node(Integer i, Node n){
	    prev = n;
	    data = i;
	}

	private Node getPrev(){
	    return prev;
	}

	private Node getNext(){
	    return next;
	}

	private Integer getValue(){
	    return data;
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
    private Node start;
    private Node end;
    private int size;

    public MyLinkedList(){
	size = 0;
	start = new Node(end, null);
	end = new Node(null, start);
    }

    public boolean add(Integer value){
	Node neW = new Node(end, value);
	end.getPrev().setNext(neW);
	end.setPrev(neW);
	size += 1;
	return true;
    }

    public int size(){
	return size;
    }
    
    public String toString(){
	Node current = start.next;
	String ans = "[";
	while(current != end){
	    ans += " " + current.getValue() + ",";
	    current = current.getNext();
	}
	return ans + "]";
    }

    public Integer get(int index){
	if(index >= size){
	    throw new IndexOutOfBoundsException();
	}
	Node current = start.next;
	for(int x = 0; x < index; x ++){
	    current = current.getNext();
	}
	return current.getValue();
    }

    public int indexOf(Integer value){
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
    
    public static void main(String[]args){
	MyLinkedList data = new MyLinkedList();
	
	data.add(4);
	data.add(5);
	data.add(6);
	System.out.println(data);
	System.out.println(""+data.get(1) + " " + data.indexOf(6) + " " + data.size());
	data.clear();
	System.out.println(data);
    }
}
