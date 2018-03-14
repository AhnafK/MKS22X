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
	for(int x = start; x <= end; x++){
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
    
    public static int select(int[] data, int pos){
	int x = partition(data,0,data.length-1);
	if(pos == x)
	    return data[pos];
	return selectH(pos, x, data);
    }

    private static int selectH(int pos, int last, int[] data){
	if(last > pos)
	    return selectH(pos, partition(data, 0, last-1), data);
	if(last < pos)
	    return selectH(pos, partition(data, last+1, data.length-1), data);
	return data[pos];
    }
    
    public static void main(String[]args){
	int[]ary = { 2, 10, 15, 23, 0,  5};
	System.out.println(""+select(ary, 0));
        
    }

}
