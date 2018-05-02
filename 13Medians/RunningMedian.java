//import java.util.*;

public class RunningMedian{
    private MyHeap<Double> small;
    private MyHeap<Double> large;

    public RunningMedian(){
	small = new MyHeap<>();
	large = new MyHeap<>(false);
    }
    
    public void add(Double a){
	System.out.println("\n\n"+large + "\n" + small + "\n\n");
	if(large.size()==0){
	    large.add(a);
	    System.out.println("\n\n"+large + "\n" + small + "\n\n____");
	}
	else if(large.size()-small.size()>1/*||(large.size() > small.size() &&)*/){
	    large.add(a);
	    small.add(large.remove());
	    System.out.println("\n\n"+large + "\n" + small + "\n\n____");
	    return;
	}
	else if(a<getMedian()){
	    small.add(a);
	    System.out.println("\n\n"+large + "\n" + small + "\n\n____");
	    return;
	}
	else{
	    if(large.size()-small.size()>1/*||(large.size() > small.size() &&)*/){
		large.add(a);
		small.add(large.remove());
		System.out.println("\n\n"+large + "\n" + small + "\n\n____");
		return;
	    }
	    large.add(a);
	    System.out.println("\n\n"+large + "\n" + small + "\n\n____");
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
	RunningMedian f = new RunningMedian();
	f.add(123.);
	f.add(536.);
	f.add(2.);
	f.add(43524.);
	System.out.println(""+f.small + "||"+ f.large+ f.getMedian());
    }
}
