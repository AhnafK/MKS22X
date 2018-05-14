import java.util.*;
public class FrontierStack implements Frontier{
    private Stack<Location> FQ;

    public FrontierStack(){
	FQ = new Stack<Location>();
    }
    
    public Location next(){
	return FQ.pop();
    }

    public void add(Location n){
	FQ.push(n);
    }

    public boolean hasNext(){
	return !FQ.empty();
    }
}
