import java.util.*;
public class Calculator{
        // private class Stack{
    // 	private LinkedList<String> stak;

    // 	private stack(String enter){
    // 	    stak = new LinkedList<String>;
    // 	    String now = "";
    // 	    for(int x = enter.length(); x < enter.length(); x++){
    // 		if(enter.charAt(x) == ' ' || x = enter.length()-1){
    // 		    stak.add(now);
    // 		    now = "";
    // 		}
    // 	    }
    // 	}

    // 	private void push(String l){
    // 	    stak.add(l);
    // 	}

    // 	private String pop(){
    // 	    return stak.pop();
    // 	}
	
    // }
    public static LinkedList<String> stack(String enter){
	LinkedList<String> stak = new LinkedList<String>();
	String now = "";
	for(int x = 0; x < enter.length(); x++){
	    if(enter.charAt(x) == ' '){
		
		stak.add(now);
		//System.out.println(now);
		now = "";
	    }
	    else{
		now+=enter.charAt(x);
	    }
	}
	stak.add(now);
	return stak;
    }
    

    public static double eval(String s){
	LinkedList<String> gravy = stack(s);
	System.out.println("first: "+gravy);
	while(gravy.size() > 1){
	    double a = Double.parseDouble(gravy.pop());
	    System.out.println("a "+a+" "+gravy);
	    double b = Double.parseDouble(gravy.pop());
	    System.out.println("b "+b+" "+gravy);
	    //while(gravy.size() > 0){
	    String c = gravy.pop();
	    System.out.println("|"+c+"|");
	    if(c.equals("+"))
		gravy.push(a+b+"");
	    else if(c.equals("-"))
		gravy.push(a-b+"");
	    else if(c.equals("/"))
		gravy.push(a/b+"");
	    else if(c.equals("*"))
		gravy.push(a*b+"");
	    else if(c.equals("%"))
		gravy.push(a%b+"");
	    else{
		gravy.push(b+"");
		//double f = a;
		//a = Double.parseDouble(gravy.pop());
		//b = Double.parseDouble(gravy.pop());
		gravy.push(a+"");
	    }
	    System.out.println(gravy);
	}
	return Double.parseDouble(gravy.pop());
    }
    public static void main(String[]args){
	System.out.println(""+eval("11 3 - 4 + 2.5 *"));
    }
}
