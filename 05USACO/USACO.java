import java.io.File;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class USACO{

    public static int[][] bronzeHO(int R, int C, int N, int[][] P){
	int max = R-1;
	int may = C-1;
	for(int x = C-1; x < C+2; x++){
	    for(int y = R-1; y < R+2; y++){
		//System.out.println("x:"+(x+1)+"y:"+(y+1));
		if(P[x][y] >= P[max][may]){
		    max = x;
		    may = y;
		}
	    }
	}
	//System.out.println("Max: " + max + " " + may +" " + (R-1) +" " + (C-1));
	return step(R,C,N,P,may,max);
    }


    public static int[][] step(int R, int C, int N, int[][] P, int Rm, int Cm){
	int New = P[Cm][Rm] - N;
	int[][] ans = P;
	//System.out.println("New:"+New);

	for(int x = C-1; x < C+2; x++){
	    for(int y = R-1; y < R+2; y++){
		//System.out.println("x:"+(x+1)+"y:"+(y+1));
		if(P[x][y] >= New){
		    P[x][y] = New;
		}
	    }
	}

	
	//testi(ans);
	return ans;
    }
    
    public static int depth(int[][] P, int E){
	int ans = 0;
	testi(P);
	for(int y = 0; y < P[0].length; y++){
	    for(int x = 0; x < P.length; x++){
		int depth = P[x][y] - E;
		if(depth >= 0)
		    ans += 72*72*depth;
	    }
	}
	return ans;
    }

    public static void testi(int[][] a) {
	String aString = "";
	for(int y = 0; y < a[0].length; y++){
	    for(int x = 0; x < a.length; x++){
		aString += a[x][y]+" ";
	    }
	    aString += "\n";
	}
	System.out.println(aString);
    }

    public static int Bronze(String filename) throws FileNotFoundException{
	File f = new File(filename);
	Scanner s = new Scanner(f);
	int c = Integer.parseInt(s.next());
	int r = Integer.parseInt(s.next());
	int P[][] = new int[r][c];
	int E = Integer.parseInt(s.next());
	int N = Integer.parseInt(s.next());
	for(int y = 0; y < P[0].length; y++){
	    for(int x = 0; x < P.length; x++){
		P[x][y] = Integer.parseInt(s.next());
	    }
	}
	//System.out.println("" + P.length + " " + P[0].length);
	testi(P);
	return depth(BronzeR(s, N, P), E);
	
    }

    public static int[][] BronzeR(Scanner s, int N, int[][] P){
	if(N == 0)
	    return P;
	return BronzeR(s,N-1,bronzeHO(Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),P));
    }
















    /*------------------------------------------------
    
    public static void Silver(Strin filename)throws FIleNotFoundException{
	File f = new File(filename);
	Scanner s = new Scanner(f);
	char[][] P = new char[Integer.parseInt(s.next())][Integer.parseInt(s.next())];
	T = Integer.parseInt(s.next());










    }







    */
    public static void main(String[]args){
	try{
	    System.out.println(""+Bronze("Data1.txt"));
	}
	catch(FileNotFoundException e){

	}
    }
}
