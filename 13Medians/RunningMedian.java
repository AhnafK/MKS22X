public class RunningMedian{
    private MyHeap<Double> small;
    private MyHeap<Double> large;

    public RunningMedian(){
	small = new MyHeap<>();
	large = new MyHeap<>(false);
    }
    
    public void add(Double a){
	if(a<getMedian()){
	    small.add(a);
	}
	else{
	    large.add(a);
	}
	if(large.size()-1>small.size()){
	    
	}
    }
    
    public Double getMedian(){
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
	f.add
	System.out.println(""+f.getMedian());
    }
}
