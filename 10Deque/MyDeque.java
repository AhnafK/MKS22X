import java.util.*;
public class MyDeque<E>{
    private int start;
    private int size;
    private E[] deq;

    @SuppressWarnings("unchecked")
    public MyDeque(int g){
	if(g < 1)
	    throw new IllegalArgumentException();
	deq =(E[])new Object[g];
	start = g/2;
	size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(){
	deq =(E[])new Object[10];
	start = 3;
	size = 0;
    }

    public int size(){
	return size;
    }

    /*
    @SuppressWarnings("unchecked")
    private void resize(){
	E[] hold = (E[])new Object[size*2];
	int phase = hold.length/2;
	for(int x = 0; x < size; x++){
	    
	}
    }
    */
    
    private void resize(){
	MyDeque<E> pres = new MyDeque<>(size*2);
	for(int x = 0; x < size; x++){
	    pres.addLast(removeFirst());
	}
    }
    
    public void addFirst(E x){
	if(size == deq.length){
	    resize();
	}
	if(start == 0){
	    start = deq.length-1;
	    deq[deq.length-1] = x;
	}
	else{
	    start -= 1;
	    deq[start] = x;
	    
	}
	size+=1;
	
    }

    public E removeFirst(){
	E ans = null;
	if(size == 0){
	    throw new NoSuchElementException();
	}
	if(start == deq.length-1){
	    ans = deq[deq.length-1];
	    start = 0;
	}
	else{
	    ans = deq[start];
	    start += 1;
	}
	size-=1;
	return ans;
    }
    
    public E removeLast(){
	E ans = null;
	if(size == 0){
	    throw new NoSuchElementException();
	}
	//System.out.println("Poop: "+Arrays.toString(deq));
	ans = deq[(size + start-1)%deq.length];
	    
	size-=1;
	return ans;
    }
    
    public void addLast(E x){
	if(size == deq.length){
	    resize();
	}
	deq[(start+size)%deq.length]=x;
	size+=1;
    }


    public String toString(){
	String ans = "[";
	for(int x = 0; x < size; x++){
	    ans += deq[(start+x)%deq.length]+", ";
	}
	return ans + "]";
    }

    public E getFirst(){if(size == 0){
	    throw new NoSuchElementException();
	}
	return deq[start];
    }
    
    public E getLast(){if(size == 0){
	    throw new NoSuchElementException();
	}
	return deq[(start+size-1)%deq.length];
    }
    
    public static void main(String[]args){
	MyDeque<Integer> f = new MyDeque<>(4);
	f.addFirst(4);
	System.out.println(""+f.size());
	f.addFirst(10);System.out.println(""+f.size()+ " " + f);f.addFirst(124);
	f.addLast(142);System.out.println(""+f.size() + f);
	System.out.println(f.removeFirst()+ " " + f + " " + f.removeLast());
	System.out.println(f);
    }
}
