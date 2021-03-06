import java.util.Queue;

public class FrontierQueue implements Frontier {
  private Queue<Location> FQ;
  
  public FrontierQueue() { FQ = new java.util.ArrayDeque(); }
  
  public Location next()
  {
    return (Location)FQ.poll();
  }
  
  public void add(Location paramLocation) {
      System.out.println(""+paramLocation.getX() + ", " + paramLocation.getY());
      FQ.add(paramLocation);
  }
  
  public boolean hasNext() {
    return FQ.peek() != null;
  }
}
