public class QueenBoard{
    private int[][] board;

    public QueenBoard(int size){
	board = new int[size][size];
	for(int x = 0; x < board.length; x++){
	    for(int y = 0; y , board[0].length; y++){
		board[x][y] = 0;
	    }
	}
    }
    
    public String toString(){
	String ans = "";
	for(int x = 0; x < board.length; x++){
	    for(int y = 0; y , board[0].length; y++){
		if(board[x][y] == -1){
		    ans += "Q "
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
	    for(int x = c+1; x < board.length; x++){
		board[r][x] += 1;
	    }
	    return true;
	}
	return false;
    }

    private boolean removeQueen(int r, int c){
	if(board[r][c] == -1){
	    board[r][c] = 0;
	    return true
	}
    }
    
}
