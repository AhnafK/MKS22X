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

    @SuppressWarnings("unchecked")
    private void resize(){
	E[] hold = (E[])new Object[size*2];
	
    }
    
    public void addFirst(E x){
	if(size == deq.length){
	    resize();
	}
	if(start == 0)
	    start = deq.length-1;
	    deq[deq.length-1] = x;
	
	else{
	    start -= 1;
	    deq[start] = x;
	    
	}
	size+=1;
	
    }

    public void removeFirst(E x){
	E ans = null;
	if(size == 0){
	    throw new NoSuchElementException();
	}
	if(start == 0){
	    ans = deq[deq.length-1];
	    deq[deq.legnth-1]=null;
	}
	else{
	    start -= 1;
	    deq[start] = null;
	    
	}
	size-=1;
	
    }

    public void addLast(E x){
	if(size == deq.length){
	    resize();
	}
	if(start+size-1 == deq.length-1)
	    deq[0] = x;
	else{
	    deq[start+size]=x;
	}
	size+=1;
    }



}
