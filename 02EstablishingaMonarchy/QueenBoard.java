public class QueenBoard{
    private int[][] board;

    public QueenBoard(int size){
	board = new int[size][size];
	for(int y = 0; y < board[0].length; y++){
	    for(int x = 0; x < board.length; x++){
		board[x][y] = 0;
	    }
	}
    }
    
    public String toString(){
	String ans = "";
	for(int y = 0; y < board[0].length; y++){
	    for(int x = 0; x < board.length; x++){
		if(board[x][y] == -1){
		    ans += "Q ";
		}
		else{
		    ans += "_ ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }

    private boolean addQueen(int r, int c){
	if(board[r][c] == 0){
	    board[r][c] = -1;
	    int y = c + 1;
	    int o = c - 1;
	    for(int x = r+1; x < board.length; x++, y++){
		if(y < board[0].length){
		    board[x][y] += 1;
		}
		if(o > 0){
		    board[x][o] += 1;
		    o--;
		}
		board[x][c] += 1;
	    }
	    return true;
	}
	return false;
    }

    public boolean solve(){
	if(solveR(0))
	    return true;
	this(board.length);
	return false;
    }

    private boolean solveR(int x){
	if(x == board.length)
	    return true;
	for(int y = 0; y < board[0].length; y++){
	    if(addQueen(x, y)){
		if(solveR(x + 1)){
		    return true;
		}
		else{
		    removeQueen(x, y);
		}
	    }
	}
	return false;
    }
    
    public int countSolutions(){
	return solveCR(0,0);
    }

    private int solveCR(int x, int ans){
	if(x == board.length)
	    return solveCR(x-1, ans + 1);
	for(int y = 0; y < board[0].length; y++){
	    if(addQueen(x, y)){
		return solveCR(x + 1, ans);
		removeQueen(x, y);
	    }
	}
	return ans;
    }
	
    private boolean removeQueen(int r, int c){
	if(board[r][c] == -1){
	    board[r][c] = 0;
	    int y = c + 1;
	    int o = c - 1;
	    for(int x = r+1; x < board.length; x++, y++){
		if(y < board[0].length){
		    board[x][y] -= 1;
		}
		if(o > 0){
		    board[x][o] -= 1;
		}
		board[x][c] -= 1;
	    }
	    return true;
	}
	return false;
    }

    public static void main(String[]args){
	QueenBoard f = new QueenBoard(5);
	System.out.println("" + f.countSolutions());
    }
    
}
