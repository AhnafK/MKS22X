public class KnightBoard{
    private int[][] board;
    private int solutions;
    
    public KnightBoard(int rows, int cols){
	board = new int[rows][cols];
	if(rows <= 0 || cols <=0)
	    throw new IllegalArgumentException();
	resetBoard();
    }

    private void resetBoard(){
	for(int x = 0; x < board.length; x++){
	    for(int y = 0; y < board[0].length; y++){
		board[x][y] = 0;
	    }
	}
    }
    
    public String toString(){
	String ans = "";
	for(int y = 0; y < board[0].length; y++){
	    for(int x = 0; x < board.length; x++){
		if((""+board[x][y]).length()==1)
		    ans += ' ';
		ans += board[x][y] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }
    
    private boolean step(int x, int y, int pos, int j){
	if(pos == 0)
	    return goodStep(x,y,2,1,j);
	if(pos == 1)
	    return goodStep(x,y,1,2,j);
	if(pos == 2)
	    return goodStep(x,y,-1,2,j);
	if(pos == 3)
	    return goodStep(x,y,-2,1,j);
	if(pos == 4)
	    return goodStep(x,y,-2,-1,j);
	if(pos == 5)
	    return goodStep(x,y,-1,-2,j);
	if(pos == 6)
	    return goodStep(x,y,1,-2,j);
	return goodStep(x,y,2,-1,j);
    }
    
    private boolean goodStep(int x, int y, int ex, int why, int j){
	if(x+ex < board.length && x+ex >= 0 && y+why < board[0].length && y+why >= 0 && board[x+ex][y+why] == 0){
	    board[x+ex][y+why] = j;
	    return true;
	}
	return false;
    }

     private boolean unStep(int x, int y, int pos){
	if(pos == 0)
	    return badStep(x,y,2,1);
	if(pos == 1)
	    return badStep(x,y,1,2);
	if(pos == 2)
	    return badStep(x,y,-1,2);
	if(pos == 3)
	    return badStep(x,y,-2,1);
	if(pos == 4)
	    return badStep(x,y,-2,-1);
	if(pos == 5)
	    return badStep(x,y,-1,-2);
	if(pos == 6)
	    return badStep(x,y,1,-2);
	return badStep(x,y,2,-1);
    }
    
    private boolean badStep(int x, int y, int ex, int why){
	if(x+ex < board.length && x+ex >= 0 && y+why < board[0].length && y+why >= 0){
	    board[x+ex][y+why] = 0;
	    return true;
	}
	return false;
    }

    //_______________________________________________________________________
    
    private boolean solveF(int x, int y, int level, int f){
	if(f == 0)
	    return solveH(x+2,y+1,level+1);
	if(f == 1)
	    return solveH(x+1,y+2,level+1);
	if(f == 2)
	    return solveH(x-1,y+2,level+1);
	if(f == 3)
	    return solveH(x-2,y+1,level+1);
	if(f == 4)
	    return solveH(x-2,y-1,level+1);
	if(f == 5)
	    return solveH(x-1,y-2,level+1);
	if(f == 6)
	    return solveH(x+1,y-2,level+1);
	return solveH(x+2,y-1,level+1);
    }
    
    public boolean solve(int startingRows,int startingCols){
	if(startingRows < 0 || startingCols <0)
	    throw new IllegalArgumentException();
	board[startingRows][startingCols] = 1;
	return solveH(startingRows,startingCols,2);
    }

    private boolean solveH(int row ,int col, int level){
	//	System.out.println(""+ board.length + " " + board[0].length + " " + level+" " + board.length*board[0].length  + "\n_____________________________________");
	if(level-1 == (board.length * board[0].length)){
	    return true;
	}
	for(int x = 0; x < 8; x++){
	    if(step(row,col,x,level)){
		//System.out.println(this);
		if(solveF(row, col, level, x))
		    return true;
		else{
		    unStep(row, col, x);
		    //System.out.println(this);
		}
	    }
	}
	return false;
    }

    //_____________________________________________________________
    
    public int countSolutions(int startingRows,int startingCols){
	if(startingRows < 0 || startingCols <0)
	    throw new IllegalArgumentException();
	solutions = 0;
	this.resetBoard();
	board[startingRows][startingCols] = 1;
	solveCR(startingRows,startingCols,2);
	return solutions;
    }

    private boolean solveCR(int row ,int col, int level){
	System.out.println(""+this+"\n\n" + solutions + "\n---\n");
	if(level-1 >= (board.length * board[0].length)){
	    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+this);
	    solutions+=1;
	}
	for(int x = 0; x < 8; x++){
	    if(step(row,col,x,level)){
		solveFC(row, col, level, x);
		unStep(row, col, x);
	    }
	}
	return false;
    }


    private boolean solveFC(int x, int y, int level, int f){
	if(f == 0)
	    return solveCR(x+2,y+1,level+1);
	if(f == 1)
	    return solveCR(x+1,y+2,level+1);
	if(f == 2)
	    return solveCR(x-1,y+2,level+1);
	if(f == 3)
	    return solveCR(x-2,y+1,level+1);
	if(f == 4)
	    return solveCR(x-2,y-1,level+1);
	if(f == 5)
	    return solveCR(x-1,y-2,level+1);
	if(f == 6)
	    return solveCR(x+1,y-2,level+1);
	return solveCR(x+2,y-1,level+1);
    }
    
    public static void main(String[]args){
	KnightBoard f = new KnightBoard(5,5);
	
	int dol = 0;
	for(int y = 0; y < 5; y++){
	    for(int x = 0; x < 5; x++){
		dol += f.countSolutions(x,y);
	    }
	}
	System.out.println("" + dol);
	
    }
}
