//import java.io.*;
import java.util.*;
public class Merge{

    public static void mergesort(int[]data){
	int[] temp = new int[data.length];
	msort(data, temp, 0, data.length-1);
    }
    
    public static void msort(int[]data, int[]temp, int lo, int hi){
	System.out.println("___\ndata: "+Arrays.toString(data)+ " " + lo + " " + hi);
	    System.out.println("temp: " + Arrays.toString(temp));
	if(lo >= hi)
	    return;
	for(int x = lo; x <= hi; x++){
	    temp[x] = data[x];
	    
	}
	int mp = (lo + hi)/2;
	System.out.println("\ndata: "+Arrays.toString(data)+ " " + lo + " "+ mp + " " + hi);
	    System.out.println("temp: " + Arrays.toString(temp));
	msort(temp, data, lo, mp);
	msort(temp, data, mp+1, hi);
	merge(temp, data, lo, mp, hi); 
    }

    public static void merge(int[]data, int[]temp, int lo, int mid, int hi){
	int mih = mid + 1;
	int l = lo;
	for(int x = 0; x < mid; x++){
	    if(mih >= hi || data[l+x] <= data[mih+x]){
		temp[x] = data[l+x];
		mih--;
	    }
	    if(l >= mid || data[l+x] >= data[mih+x]){
		temp[x] = data[mih+x];
		l--;
	    }
	}
    }

    public static void main(String[]args){
	int[] data = {2,3,4,4,5,2,2,79,5};
	//mergesort(data);
	merge(data, new int[data.length],0,data.length/2,data.length);
	System.out.println(Arrays.toString(data));
    }
}
