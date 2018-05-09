import java.util.*;
public class FrontierQueue implements Frontier{
    private Queue<Location> FQ;

    public FrontierQueue(){
	FQ = new ArrayDeque<Location>();
    }
    
    public Location next(){
	return FQ.poll();
    }

    public void add(Location n){
	FQ.add(n);
    }

    public boolean hasNext(){
	return FQ.peek()!=null;
    }
}
