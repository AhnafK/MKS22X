public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int distance;

    public Location(int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }

    public int compareTo(Location o){
	return distance - o.getDistance();
    }
    
    public void setDistance(Maze m){
        distance = Math.abs(x - m.getEnd().getX()) + Math.abs(y - m.getEnd().getY());
    }

    public int getDistance(){
	return distance;
    }
    
    public boolean hasPrev(){
	return previous != null;
    }
    
    public Location getPrev(){
	return previous;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public void set(Maze m, char c){
	m.set(getX(),getY(),c);
    }
    
    public char getPart(Maze m){
	return m.get(x,y);
    }
    
}
