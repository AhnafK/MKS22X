import java.util.*;
import java.io.*;
public class Maze{


    private char[][]maze;
    private boolean animate;//false by default

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!


      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: 

         throw a FileNotFoundException or IllegalStateException

    */

    public Maze(String filename)throws FileNotFoundException{
	File f = new File(filename);
	Scanner s = new Scanner(f);
	Scanner t = new Scanner(f);
	boolean E = false;
	boolean S = false;
	int x = s.nextLine().length();
	int y = 1;
	while(s.hasNextLine()){
	    y+=1;
	    s.nextLine();
	}
	maze = new char[x][y];
	y = 0;
	while(t.hasNextLine()){
	    String now = t.nextLine();
	    for(int q = 0; q < now.length(); q++){
		maze[q][y] = now.charAt(q);
		if(now.charAt(q) == 'E'){
		    if(E)
			throw new IllegalStateException();
		    E = true;
		}
		if(now.charAt(q) == 'S'){
		    if(S)
			throw new IllegalStateException();
		    S = true;
		}
	    }
	    y++;
	}
	if(!E||!S)
	    throw new IllegalStateException();
	
    }

    public String toString(){
	String ans = "";
	for(int y = 0; y < maze[0].length; y++){
	    for(int x = 0; x < maze.length; x++){
		ans += maze[x][y];
	    }
	    ans += "\n";
	}
	return ans;
    }
    
    private boolean move(int row, int col, int way){
	if(way == 0 && maze[row][col+1] != '#' && maze[row][col+1] != '@' && maze[row][col+1] != '.'){
	    maze[row][col+1] = '@';
	    return true;
	}
	if(way == 1 && maze[row+1][col] != '#' && maze[row+1][col] != '@' && maze[row][col+1] != '.'){
	    maze[row+1][col] = '@';
	    return true;
	}
	if(way == 2 && maze[row][col-1] != '#' && maze[row][col-1] != '@' && maze[row][col+1] != '.'){
	    maze[row][col-1] = '@';
	    return true;
	}
	if(way == 3 && maze[row-1][col] != '#' && maze[row-1][col] != '@' && maze[row][col+1] != '.'){
	    maze[row-1][col] = '@';
	    return true;
	}
	return false;
    }

    private boolean unMove(int row, int col, int way){
	if(way == 2 && maze[row][col+1] == '@'){
	    maze[row][col+1] = '.';
	    return true;
	}
	if(way == 3 && maze[row+1][col] == '@'){
	    maze[row+1][col] = '.';
	    return true;
	}
	if(way == 0 && maze[row][col-1] == '@'){
	    maze[row][col-1] = '.';
	    return true;
	}
	if(way == 1 && maze[row-1][col] == '@'){
	    maze[row-1][col] = '.';
	    return true;
	}
	return false;
    }
    
    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    public int solve(){

            //find the location of the S.
	int r = 0;
	int c = 0;
	for(int y = 0; y < maze[0].length; y++){
	    for(int x = 0; x < maze.length; x++){
		if(maze[x][y] == 'S'){
		    r = x;
		    c = y;
		}
	    }
	}

            //erase the S
	maze[r][c] = '@';

            //and start solving at the location of the s.
	
            //return solve(???,???);
	return solve(r,c,1);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'

            Note: This is not required based on the algorithm, it is just nice visually to see.
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col, int count){ //you can add more parameters since this is private
	
	
        //automatic animation! You are welcome.
        if(animate){

            clearTerminal();
            System.out.println(this);
	    System.out.println("" + row + " " + col + " ");
            wait(100);
        }
	
        //COMPLETE SOLVE
	if(maze[row][col]=='E')
	    return count;
	for(int x = 0; x < 4; x++){
	    if(move(row,col,x)){
		int p = solveG(row, col, x, count+1);
		if(p != -1)
		    return p;
		if(unMove(row, col, x)){
			
		    if(animate){

			clearTerminal();
			System.out.println(this);
			System.out.println("" + row + " " + col + " ");
			wait(100);
		    }

		}
	    }
	}
        return -1; //so it compiles
    }

    private int solveG(int row, int col, int way, int level){
	if(way == 0){
	    return solve(row,col+1, level);
	}
	if(way == 1){
	   return  solve(row+1, col, level);
	}
	if(way == 2){
	    return solve(row, col-1, level);
	}
	    return solve(row-1,col, level);
    }
    
    public static void main(String[]args){
	try{
	    Maze m = new Maze("Data1.dat");
	    m.setAnimate(true);
	    System.out.println("" + m.solve());
	}catch(FileNotFoundException | IllegalStateException  e){
	    System.out.println("Error1");
	}
    }
    
}
