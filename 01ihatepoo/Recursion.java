public class Recursion{
    public int fact(int n){
	if(n < 0)
	    throw new IllegalArgumentException();
	if(n == 0)
	    return 1;
	return n*fact(n-1);
    }

    public int fib(int d){
	if (d < 0)
	    throw new IllegalArgumentException();
	if(d == 0)
	    return 0;
	if(d == 1)
	    return 1;
	return helperfib(2,d,1,0);
    }

    public int helperfib(int n, int end, int one, int two){
	if(n==end){
	    return one+two;
	}
	return helperfib(n+1, end, one + two, one);
    }

    
    public double sqrt(double n){
	if (n < 0)
	    throw new IllegalArgumentException();
	return helpersqrt(n, 1);
    }

    public double helpersqrt(double n, double guess){
	if((guess*guess) == n)
	    return guess;
	return helpersqrt(n,( n / guess + guess) / 2);
    }
    
    public static void main(String[]args){
	Recursion f = new Recursion();
	System.out.println(f.sqrt(Double.parseDouble(args[0])));
    }
}
