//import java.util.*;

public class RunningMedians{
    private MyHeap<Double> small;
    private MyHeap<Double> large;

    public RunningMedians(){
	small = new MyHeap<>();
	large = new MyHeap<>(false);
    }
    
    public void add(Double a){
	//System.out.println("\n\nlarge: "+large + "\nsmall: " + small + "\nsize:"+small.size()+ " " + large.size() + "\n");
	if(large.size()==0){
	    large.add(a);
	    //System.out.println("\n\n"+large + "\n" + small + "\n1\n____");
	}
	else if(large.size()-small.size()>=1 && a > large.peek()){
	    large.add(a);
	    small.add(large.remove());
	    //System.out.println("\n\n"+large + "\n" + small + "\n2\n____");
	    return;
	}
	else if(large.size()-small.size()<=-1 && a < large.peek()){
	    small.add(a);
	    large.add(small.remove());
	    //System.out.println("\n\n"+large + "\n" + small + "\n2\n____");
	    return;
	}
	else if(a<large.peek()){
	    small.add(a);
	    //System.out.println("\n\n"+large + "\n" + small + "\n2\n____");
	    if(large.size()-small.size()>1/*||(large.size() > small.size() &&)*/){
		large.add(a);
		small.add(large.remove());
		//System.out.println("\n\n"+large + "\n" + small + "\n3\n____");
		return;
	    }
	    return;
	}
	else{/*
	    if(large.size()-small.size()>1){
		large.add(a);
		small.add(large.remove());
		System.out.println("\n\n"+large + "\n" + small + "\n3\n____");
		return;
		}*/
	    large.add(a);
	    //System.out.println("\n\n"+large + "\n" + small + "\n4\n____");
	    
	    return;
	}
	
    }
    
    public Double getMedian(){
	//System.out.println(large.size()+"");
	//System.out.println(small.size()+"");
	if(large.size() > small.size()){
	    return large.peek();
	}
	else{
	    return (large.peek()+small.peek())/2;
	}
    }

    public static void main(String[]args){
	RunningMedians f = new RunningMedians();
	f.add(123.);
	f.add(536.);
	f.add(2.);
	f.add(43524.);
	System.out.println(""+ f.getMedian());
    }
}
