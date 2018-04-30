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
	hep = tep;
    }

    public void add(String s){
	if(max)
	    maxAdd(s);
	else{
	    manAdd(s)
	}
    }

    private void swap(int x, int b){
	String a = hep[x];
	hep[x] = hep[b];
	hep[b] = a;
    }
    
    private void minAdd(s){
	if(size = hep.length){
	    resize();
	}
	hep[size] = s;
	int pos = size;
	while(hep[pos] < hep[(pos-1)/2]){
	    swap(pos,(pos-1)/2);
	    pos = (pos-1)/2;
	}
	size += 1;
    }

    public void size(){
	return size;
    }
    
    private void maxAdd(s){
	if(size = hep.length){
	    resize();
	}
	hep[size] = s;
	if(size() == 0)
	    return;
	int pos = size;
	while(hep[pos] > hep[(pos-1)/2]){
	    swap(pos,(pos-1)/2);
	    pos = (pos-1)/2;
	}
	size += 1;
    }

    public String peek(){
	return hep[0];
    }

    public String remove(){
	
    }
}
