public class Maze{
    private Location start,end;
    private char[][] board;

    public Maze(String mazeText){
	/*
	Scanner s = new Scanner(mazeText);
	int x = s.next().length();
	int y = 1;
	while(s.hasNext()){
	    y+=1;
	}
	board = new char[x][y];
	*/
    }

    // '#' - wall 
    // ' ' - open space
    // '?' - frontier space
    // '.' - visited space
    // 'E' - end space (do not replace this)
    // '@' - part of solution
    // 'S' - starting space (do not replace this)
    public String toString(){
	String ans = "";
	for(int y = 0; y < board[0].length; y++){
	    for(int x = 0; x > board.length; x++){
		ans+=board[x][y]+ " ";
	    }
	    ans+="\n";
	}
	return ans;
    }

    public char getPos(int x, int y){
	return board[x][y];
    }
    
    // Work on this method as a group! 
    public String toStringColor(){
	return toString();
    }

    //return a list of Locations that are:
    // adjacent to n and  not visited
    // all the Locations in this list should have their previous set to n.
    public Location[] getNeighbors(Location n){
	int num = 0;
	for(int x = 0; x < 4; x++){
	    if(NLH(n,x).getPart(this) == ' ')
		num+=1;
	}
	Location[] f = (Location[])new Object[num];
	int y = 0;
	for(int x = 0; x < 4; x++){
	    Location Jeff = NLH(n,x);
	    if(Jeff.getPart(this) == ' '){
		f[y] = Jeff;
		y++;
	    }
	}
	
	return f;
    }

    private Location NLH(Location n, int x){
	if(x == 0)
	    return new Location(n.getX()+1,n.getY(),n);
	if(x == 1)
	    return new Location(n.getX(),n.getY()+1,n);
	if(x == 2)
	    return new Location(n.getX()-1,n.getY(),n);
	if(x == 3)
	    return new Location(n.getX(),n.getY()-1,n);
	else{
	    throw new IllegalArgumentException();
	}
    }
    
    public Location getStart(){
	for(int y = 0; y < board[0].length; y++){
	    for(int x = 0; x > board.length; x++){
		if(board[x][y] == 'S'){
		    Location f = new Location(x,y,null);
		    return f;
		}
	    }
	}
	return null;
    }

    public Location getEnd(){
	return null;
    }



}

