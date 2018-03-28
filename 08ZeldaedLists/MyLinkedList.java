public  class MyLinkedList{
    private class Node{
	private Node prev;
	private Node next;
	private Integer data;

	private Node(){};
	
	private Node(Node l, Node n, Integer i){
	    prev = l;
	    next = n;
	    data = i;
	}
	
	private Node(Node n, Integer i){
	    next = n;
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
    }
    private Node start;
    private Node end;
    private int size;

    public MyLinkedList(){
	size = 0;
	start = new Node();
	end = new Node();
    }

    public boolean add(Integer value){
	start.next = new Node(start, value);
	size += 1;
	return true;
    }

    public int size(){
	return size;
    }
    
    public String toString(){
	Node current = start.next;
	String ans = "[";
	while(current.next != end){
	    ans += " " + current.getValue() + ",";
	}
	return ans + "]";
    }

    
}
