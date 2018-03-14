import java.util.Random;
import java.io.*;
import java.util.*;


public class Quick{
    public static int partition(int [] data, int start, int end){
	
	Random r = new Random();
	int pos = r.nextInt(end - start);
	int pivot = data[start+pos];
	data[pos] = data[start];
	data[start] = pivot;
	
	int small = start+1;
	int large = end;
	for(int x = 1; x <= end; x++){
	    if(data[x] < pivot){
		int keep = data[small];
		data[small] = data[x];
		data[x] = keep;
		small++;
	    }
	}
	data[start] = data[small-1];
	data[small-1] = pivot;
	System.out.println(Arrays.toString(data));
	return small-1;
    }
    
    
    
    public static void main(String[]args){
	int[] f = { 999,999,999,4,1,0,3,2,999,999,999};
	System.out.println(""+partition(f  , 0, 10));
	//partition(f);
    }

}
