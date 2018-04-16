import java.util.*;
public class Sorts{

    public static void radixsort(MyLinkedListImproved<Integer> data){
	MyLinkedListImproved<Integer>.Literator L = data.iterator();
	int g = (""+data.get(data.max())).length();
	@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] whoa= new MyLinkedListImproved [10];
	for(int poopy = 0; poopy < g; poopy++){
	    //System.out.println(""+data+ " " + poopy + " " + g);
	    L = data.iterator();
	    for(int e = 0; e < 10; e++){
		whoa[e] = new MyLinkedListImproved<>();
	    }
	    while(L.hasNext()){
		Integer Pres = L.next();
		int position = Pres/(int)Math.pow(10,poopy)%10;
		//System.out.println("pos: "+Pres + "  " + position + " " + whoa[position]);
		whoa[Pres/(int)Math.pow(10,poopy)%10].add(Pres);
	    }
	    data.clear();
	    data.extend(whoa[0]);
	    //System.out.println(data);
	    for(int x = 1; x < 10; x++){
		
		data.extend(whoa[x]);
		//System.out.println("data: " + data+ "\n___________");
	    }
	    //System.out.println("Loop: "+poopy+ "  " +data);
	}
    }
    
    
}
