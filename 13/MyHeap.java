import java.util.*;

public class MyHeap{
    private String[] hep;
    private boolean max;
    private int size;
    
    public MyHeap(){
	max = true;
	hep = new String[10];
	size = 0;
    }

    public MyHeap(boolean p){
	max = p;
	hep = new String[10];
	size = 0;
    }

    private void resize(){
	String[] temp = new String[size*2];
	for(int x = 0; x < size; x++){
	    temp[x] = hep[x];
	}
	hep = temp;
    }

    public void add(String s){
	if(max)
	    maxAdd(s);
	else{
	    minAdd(s);
	}
    }

    private void swap(int x, int b){
	String a = hep[x];
	hep[x] = hep[b];
	hep[b] = a;
    }
    
    private void minAdd(String s){
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
    
    private void maxAdd(String s){
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

    public String peek(){
	return hep[0];
    }

    private boolean big(String a,String b){
	if(b == null)
	    return true;
	if(a.compareTo(b)>0)
	    return true;
	return false;
    }

    private boolean small(String a,String b){
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

    public String remove(){
	String ans = peek();
	hep[0] = hep[size-1];
	size--;
	hep[size] = null;
	heapify();
	
	return ans;
    }

    public static void main(String[]args){
	MyHeap f = new MyHeap();
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
