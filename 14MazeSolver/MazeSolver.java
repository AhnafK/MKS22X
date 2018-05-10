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
	Frontier Q = new FrontierQueue();
	Q.add(maze.getStart());
	if(Q.hasNext()){
	    System.out.println("kewl");
	}
	else{
	    System.out.println("boo");
	}
	while(Q.hasNext()){
	    Location Ree = Q.next();
	    System.out.println(Ree.getPart(maze));
	    maze.walk(Ree);
	    //Ree.getX();
	    if(Ree.getX() == maze.getEnd().getX() && Ree.getY() == maze.getEnd().getY()){
		return true;
	    }
	    Location[] g = maze.getNeighbors(Ree);
	    for(int l = 0; l < g.length; l++){
		Q.add(g[l]);
	    }
	}
	return false;
    }

    public String toString(){
	return maze.toString();
    }
}
