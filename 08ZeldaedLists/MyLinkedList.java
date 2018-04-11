public  class MyLinkedList{
    private class Node{
	private Node prev;
	private Node next;
	private Integer data;

	private Node(){}

	private Node(Integer value){
	    data = value;
	}
	
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

	private Integer setValue(Integer i){
	    Integer ans = data;
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
    private Node start;
    private Node end;
    private int size;

    public MyLinkedList(){
	size = 0;
	start = new Node();
	start.setNext(end);
	end = new Node();
	end.setPrev(start);
	
    }

    public boolean add(Integer value){
	Node neW = new Node(end, value);
	end.getPrev().setNext(neW);
	end.setPrev(neW);
	size += 1;
	return true;
    }


    
    public boolean add(int index, Integer value){
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
	Node current = start.next;
	String ans = "[";
	while(current != end){
	    ans += " " + current.getValue() + ",";
	    current = current.getNext();
	}
	
	return ans + "]";
    }

    private Node getNode(int index){
	//System.out.println(""+ size + " " + index);
	if(index == -1)
	    return start;
	if(index == size)
	    return end;
	if(index > size){
	    throw new IndexOutOfBoundsException();
	}
	Node current = start.next;
	for(int x = 0; x < index; x ++){
	    current = current.getNext();
	}
	return current;
    }
    
    public Integer get(int index){
	return getNode(index).getValue();
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

    public Integer set(int index, Integer value){
	Node current = getNode(index);
	return current.setValue(value);
    }

    public boolean remove(Integer value){
	Node current = getNode(indexOf(value));
	return current.getPrev().setNext(current.getNext()) &&
	    current.getNext().setPrev(current.getPrev());
    }

    public Integer remove(int index){
	Node current = getNode(index);
	current.getPrev().setNext(current.getNext());
	current.getNext().setPrev(current.getPrev());
	return current.getValue();
    }
    
    public static void main(String[]args){
	MyLinkedList data = new MyLinkedList();
	
	data.add(4);
	data.add(5);
	data.add(6);
	data.add(3,10);
	System.out.println(data);
	data.set(1,100);
	System.out.println(""+data.get(1) + " " + data.indexOf(6) + " " + data.size());
	data.clear();
	System.out.println(data);
    }
}
