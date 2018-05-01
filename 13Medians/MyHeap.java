import java.util.*;

public class MyHeap<E extends Comparable<E>>{
    private E[] hep;
    private boolean max;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHeap(){
	max = true;
	hep = (E[])new Comparable[10];
	size = 0;
    }
    @SuppressWarnings("unchecked")
    public MyHeap(boolean p){
	max = p;
	hep = (E[])new Comparable[10];
	size = 0;
    }
    @SuppressWarnings("unchecked")
    private void resize(){
	E[] temp = (E[])new Comparable[size*2];
	for(int x = 0; x < size; x++){
	    temp[x] = hep[x];
	}
	hep = temp;
    }

    public void add(E s){
	if(max)
	    maxAdd(s);
	else{
	    minAdd(s);
	}
    }

    private void swap(int x, int b){
	E a = hep[x];
	hep[x] = hep[b];
	hep[b] = a;
    }
    
    private void minAdd(E s){
	if(size == hep.length){
	    resize();
	}
	hep[size] = s;
	int pos = size;
	while(small(hep[pos],hep[(pos-1)/2])){
	    swap(pos,(pos-1)/2);
	    pos = (pos-1)/2;
	}
	size += 1;
    }

    public int size(){
	return size;
    }
    
    private void maxAdd(E s){
	if(size == hep.length){
	    resize();
	}
	hep[size] = s;
	if(size() == 0){ 
	    size += 1;
	    return;
	}
	int pos = size;
	while(big(hep[pos],hep[(pos-1)/2])){
	    swap(pos,(pos-1)/2);
	    pos = (pos-1)/2;
	}
	size += 1;
    }

    public E peek(){
	return hep[0];
    }

    private boolean big(E a,E b){
	if(b == null)
	    return true;
	if(a.compareTo(b)>0)
	    return true;
	return false;
    }

    private boolean small(E a,E b){
	if(b==null)
	    return true;
	if(a.compareTo(b)<0)
	    return true;
	return false;
    }


    private void heapify(){
	for(int x = size-1; x > 0; x--){
	    int posa = (x-1)/2*2+1;
	    int posb = (x-1)/2*2+2;
	    int posp = (x-1)/2;
	    /*
	    if(big(hep[posa],hep[posb])){
		if(big(hep[posa],hep[posp])){
		    swap(posa,posp);
		}
	    }else if(big(hep[posb],hep[posp])){
		swap(posb,posp);
	    }
	    */
	    push(posa,posb,posp);
	}
    }

    private void push(int posa,int posb,int posp){
	if(max){
	    if(big(hep[posa],hep[posb])){
		if(big(hep[posa],hep[posp])){
		    swap(posa,posp);
		}
	    }else if(big(hep[posb],hep[posp])){
		swap(posb,posp);
	    }
	}
	else{
	    if(small(hep[posa],hep[posb])){
		if(small(hep[posa],hep[posp])){
		    swap(posa,posp);
		}
	    }else if(small(hep[posb],hep[posp])){
		swap(posb,posp);
	    }
	}
    }

    public E remove(){
	E ans = peek();
	hep[0] = hep[size-1];
	size--;
	hep[size] = null;
	heapify();
	
	return ans;
    }

    public String toString(){
	return Arrays.toString(hep);
    }
    
    public static void main(String[]args){
	MyHeap<String> f = new MyHeap<>();
	f.add("J");
	System.out.println(""+f.size);
	f.add("K");
	System.out.println(""+f.size);
	f.add("j");
	System.out.println(""+f.size);
	System.out.println(f.remove());
	System.out.println(""+f.size);
	System.out.println(Arrays.toString(f.hep));
    }
}
