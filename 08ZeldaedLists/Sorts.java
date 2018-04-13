import java.util.*;
public class Sorts{

    public static void radixsort(MyLinkedListImproved<Integer> data){
	MyLinkedListImproved<Integer>.Literator L = data.iterator();
	int g = (""+data.max()).length();
	@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] whoa= new MyLinkedListImproved[10];
	for(int poopy = 0; poopy < g; poopy++){
	    L = data.iterator();
	    while(L.hasNext()){
		Integer Pres = L.next();
		whoa[Pres/(int)Math.pow(10,poopy)%10].add(Pres);
	    }
	    data = whoa[0];
	    for(int x = 1; x < 10; x++){
		data.extend(whoa[x]);
	    }
	}
    }
    
    
}
