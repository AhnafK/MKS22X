public class KnightBoard{
    int[][] board;
    
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
	for(int x = 0; x < board.length; x++){
	    for(int y = 0; y < board.length; y++){
		if((""+board[x][y]).length()==1)
		    ans += ' ';
		ans += board[x][y] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }


    
}
