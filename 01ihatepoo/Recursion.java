public class Recursion{
    boolean magic = false;
    public int fact(int n){
	if(n < 0)
	    throw new IllegalArgumentException();
	if(n == 0)
	    return 1;
	return n*fact(n-1);
    }

    public void mgc(){
	magic = true;
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

    public static boolean closeEnough(double a, double b){
	if(a==0.0 && b==0.0)return true;
	if(a==0.0)return Math.abs(b) < 0.00000000001;
	if(b==0.0)return Math.abs(a) < 0.00000000001;
	return Math.abs(a-b)/a < 0.0001;
    }
    
    public double helpersqrt(double n, double guess){
	if((guess*guess) == n || closeEnough(n,guess*guess))
	    return guess;
	if (magic)
	    System.out.println("" + guess + "      "  + (guess*guess));
	guess =  ( n / guess + guess) / 2;
	return helpersqrt(n,guess);
    }
    
    public static void main(String[]args){
	Recursion f = new Recursion();
	f.mgc();
	double g = f.sqrt(Double.parseDouble(args[0]));
	System.out.println("" + g + "      " + g*g);
    }
}
