import java.util.*;
public class Calculator{
        private class Stack{
	private LinkedList<String> stak;

	private stack(String enter){
	    stak = new LinkedList<String>;
	    String now = "";
	    for(int x = enter.length(); x < enter.length(); x++){
		if(enter.charAt(x) == ' ' || x = enter.length()-1){
		    stak.add(now);
		    now = "";
		}
	    }
	}

	private void push(String l){
	    stak.add(l);
	}

	private String pop(){
	    return stak.pop();
	}
	
    }

    public static double eval(String s){
	stack gravy = new stack(s);
	ListIterator<String> = gravy.ListIterator();
	while(gravy.hasNext()){
	    double f = (double)gravy.next();
	    double d = (double)gravy.next();
	    String g = gravy.next();
	    if("+".equals(g)){
		f + d
	    }
	}
    }
}
