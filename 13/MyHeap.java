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
	if(size() == 0)
	    return;
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
	if(a.compareTo(b)>0)
	    return true;
	return false;
    }

    private boolean small(String a,String b){
	if(a.compareTo(b)<0)
	    return true;
	return false;
    }

/*
    private void heapify(){
	for(int x = size-1; x > 0; x--){
	    int posa = x;
	    int posb
	}
    }
*/
    public String remove(){
	if(size <= hep.length-1)
	    resize();
	hep[hep.length-1]=hep[0];
	return hep[hep.length-1];
    }
}
