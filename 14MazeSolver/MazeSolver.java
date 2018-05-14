public class MazeSolver{
    private Maze maze;
    private Frontier frontier;

    public MazeSolver(String mazeText){
	maze = new Maze(mazeText);
    }

    //Default to BFS
    public boolean solve(){ return solve(0); }
    
    //mode: required to allow for alternate solve modes.
    //0: BFS
    //1: DFS
    public boolean solve(int mode){
	//initialize your frontier
	//while there is stuff in the frontier:
	//  get the next location
	//  process the location to find the locations (use the maze to do this)
	//  check if any locations are the end, if you found the end just return true!
	//  add all the locations to the frontier
	//when there are no more values in the frontier return false
	Frontier Q;
	boolean A = false
	if(mode == 1){
	    Q = new FrontierStack();
	}
	else if(mode == 2){
	    Q = new FrontierPriorityQueue();
	}
	else if(mode == 3){
	    A = true;
	    Q = new FrontierPriorityQueue();
	}
	else{
	    Q = new FrontierQueue();
	}
	Q.add(maze.getStart());
	Location Ree = Q.next();
	//if(Q.hasNext())
	//    System.out.println("G");
	Location[] g = maze.getNeighbors(Ree);
	for(int l = 0; l < g.length; l++){
		Q.add(g[l]);
	    }
	
	//if(Q.hasNext())
	//    System.out.println("F");
	while(Q.hasNext()){
	    Ree = Q.next();
	    
	    if(Ree.getX() == maze.getEnd().getX() && Ree.getY() == maze.getEnd().getY()){
		while(Ree.hasPrev()&&!(Ree.getX() == maze.getStart().getX() && Ree.getY() == maze.getStart().getY())){
		    Ree = Ree.getPrev();
		    Ree.set(maze, '@');
		    
		}
		return true;
	    }
	    Ree.set(maze,'.');
	    g = maze.getNeighbors(Ree);
	    if(g.length > 0){
	    for(int l = 0; l < g.length; l++){
		Q.add(g[l]);
	    }
	    //System.out.println(""+maze);
	    }
	}
	return false;
    }

    public String toString(){
	return maze.toString();
    }

    public Maze maz(){
	return maze;
    }
}
