import java.util.*;
public class Sorts{

    public static void radixsort(MyLinkedListImproved<Integer> data){
	MyLinkedListImproved<Integer>.Literator L = data.iterator();
	Integer f = data.get(data.min());
	/*
	  if(f < 0){
	  MyLinkedListImproved<Integer> dtb = new MyLinkedListImproved<>();
	  MyLinkedListImproved<Integer>.Literator o = data.iterator();
	  while(o.hasNext()){
	  Integer now = o.next();
	  if(now > 0){
	  dtb.add(now);
	  System.out.println("" + now);
	  data.remove(now);
	  }
	  }



	    
	  int g = (""+data.get(data.max())).length();
	  @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] whoa= new MyLinkedListImproved [10];
	  for(int poopy = 0; poopy < g; poopy++){
	
	  L = data.iterator();
	  for(int e = 0; e < 10; e++){
	  whoa[e] = new MyLinkedListImproved<>();
	  }
	  while(L.hasNext()){
	  Integer Pres = L.next();
	  int position = Pres/(int)Math.pow(10,poopy)%10;
		
	  whoa[Pres/(int)Math.pow(10,poopy)%10].add(Pres);
	  }
	  data.clear();
	  data.extend(whoa[9]);
		
	  for(int x = 8; x <= 0; x--){
	  data.extend(whoa[x]);
	  }
	  }

	  int d = (""+dtb.get(dtb.max())).length();
	  @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] whoaa= new MyLinkedListImproved [10];
	  for(int poopy = 0; poopy < d; poopy++){
	
	  L = dtb.iterator();
	  for(int e = 0; e < 10; e++){
	  whoaa[e] = new MyLinkedListImproved<>();
	  }
	  while(L.hasNext()){
	  Integer Pres = L.next();
	  int position = Pres/(int)Math.pow(10,poopy)%10;
		
	  whoaa[Pres/(int)Math.pow(10,poopy)%10].add(Pres);
	  }
	  dtb.clear();
	  dtb.extend(whoa[0]);
		
	  for(int x = 1; x < 10; x++){
	  dtb.extend(whoaa[x]);
	  }
	  }
	  data.extend(dtb);
	    
	  }
	
	
	  else{*/
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
    //}
    
	public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){ 
	    //either blank method
	    //OR
	    //radixsort(data)
	}
    
    
    
}
