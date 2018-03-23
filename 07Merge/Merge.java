//import java.io.*;
import java.util.*;
public class Merge{

    public static void mergesort(int[]data){
	int[] temp = new int[data.length];
	msort(data, temp, 0, data.length-1);
    }
    
    public static void msort(int[]data, int[]temp, int lo, int hi){
	//System.out.println("___\ndata: "+Arrays.toString(data)+ " " + lo + " " + hi);
	    //System.out.println("temp: " + Arrays.toString(temp));
	if(lo >= hi)
	    return;
	for(int x = lo; x <= hi; x++){
	    temp[x] = data[x];
	    
	}
	int mp = (lo + hi)/2;
	//System.out.println("\ndata: "+Arrays.toString(data)+ " " + lo + " "+ mp + " " + hi);
	    //System.out.println("temp: " + Arrays.toString(temp));
	msort(temp, data, lo, mp);
	msort(temp, data, mp+1, hi);
	merge(temp, data, lo, mp, hi); 
    }

    public static void merge(int[]data, int[]temp, int lo, int mid, int hi){
	int mih = mid + 1;
	int g = lo;
	boolean gmax = false;
	boolean hmax = false;
	for(int x = 0; x <= hi && (x + g <= mid || x + mih <= hi); x++){
	    if(hmax && !gmax){
		temp[x] = data[g+x];
		if(g == mid-1)
		    gmax = true;
		//System.out.println("l: " + (g + x) + " mid: " + mid);
	    }else if(!hmax && gmax){
		temp[x] = data[mih+x];
		if(mih == hi)
		    hmax = true;
	    }else if(!gmax && data[g+x] <= data[mih+x]){
		temp[x] = data[g+x];
		mih--;
		//System.out.println("l: " + (g + x) + " mid: " + mid);
	    }else if(!hmax && data[g+x] >= data[mih+x]){
		temp[x] = data[mih+x];
		g--;
	    }
	    if(mih+x > hi)
		hmax = true;
	    if(g+x >= mid)
		gmax = true;
	    //System.out.println(Arrays.toString(data)+ " " + Arrays.toString(temp) +" 1: " + (x+g) + " 2: " + (mih + x) + " mid:"+mid + " hi: "+hi);
	}
	//System.out.println(Arrays.toString(temp));
	for(int x = lo; x <= hi; x++){
	    data[x] = temp[x];
	    
	}
    }
    /*
    public static void merge(int[]data, int[]temp, int lo, int mid, int hi){
	int h = mid + 1;
	int s = l;
	while()
    }
    */

    public static void main(String[]args){
	int[] data = {2,3,4,23123,354,56,547,657567,67856,856,83,4235,2,2,3,5};
	mergesort(data);
	//merge(data, new int[data.length],0,3,data.length-1);
	System.out.println(Arrays.toString(data));
    }
}
