public class KnightBoard{
    private int[][] board;
    
    public KnightBoard(int rows, int cols){
	board = new int[rows][cols];
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
    
    public static void main(String[]args){
	KnightBoard f = new KnightBoard(5,5);
	if(f.solve(0,0))
	    System.out.println("YAY \n" + f);
    }
}
