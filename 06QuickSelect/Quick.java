import java.util.Random;
import java.io.*;
import java.util.*;


public class Quick{
    /* public static int partition(int [] data, int start, int end){
	if(end == start)
	    return end;
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
	//System.out.println(Arrays.toString(data));
	return small-1;
    }
    */

    public static int select(int[] data, int pos){
	int[] x = partition(data,0,data.length-1);
	if(pos <= x[1] && pos >= x[0])
	    return data[pos];
	return selectH(pos, x, data);
    }

    private static int selectH(int pos, int[] last, int[] data){
	//System.out.println("pos: " + pos + " " + data[pos]);
	if(last[1] >= pos && last[0] <= pos)
	    return data[pos];
	if(last[0] > pos)
	    return selectH(pos, partition(data, 0, last[0]), data);
	if(last[1] < pos)
	    return selectH(pos, partition(data, last[1], data.length-1), data);
	return data[pos];
	
    }
    
    public static void swap(int[] data, int x, int y){
	int pc = data[x];
	data[x] = data[y];
	data[y] = pc;
    }

    public static int[] partition(int [] data, int start, int end){
	System.out.println("args:"+ start + " " + end);
	Random r = new Random();
	int pos = r.nextInt(end - start)+start;
	System.out.println(""+pos);
	int pivot = data[pos];
	
	data[pos] = data[start];
	data[start] = pivot;
	
	int small = start;
	int large = end;
	int i = start+1;
	while(i <= large){
	    if(data[i] == pivot)
		i++;
	    else if(data[i] > pivot){
		swap(data, i, large);
		large--;
	    }
	    else if(data[i] < pivot){
		swap(data, i, small);
		small++;
		i++;
	    }
	    System.out.println(Arrays.toString(data)+pivot+" "+small + " " + i + " " + large);
	}
	
	int[] ary = {small, large};
	System.out.println(Arrays.toString(ary));
	return ary;
    }

    public static void quickSort(int[] data){
	sortH(data, data.length-1, 0, partition(data, 0, data.length-1));
    }

    public static void sortH(int[]data, int hi, int lo, int[] last){
	if(last[1] < hi-1)
	    sortH(data,last[1],last[0], partition(data,last[1],hi));
	if(last[0] > lo+1)
	    sortH(data,last[1],last[0], partition(data,lo, last[0]-1));
    }

    public static void main(String[]args){
	int[]ary = { 2, 10, 15, 23, 0,  5};
	System.out.println("ans: "+select(ary, 4));
	
	/*
	int[]arry = { 2, 10, 15, 23, 0,  5};
	quickSort(arry);
	System.out.println(Arrays.toString(arry));
	*/
    }
    
}
