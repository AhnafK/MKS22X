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
	for(int x = 0; x < board.length; x++){
	    for(int y = 0; y < board[0].length; y++){
		if((""+board[x][y]).length()==1)
		    ans += ' ';
		ans += board[x][y] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    private boolean step(int x, int y, int pos){
	if(pos == 0 &&){
	    board[x+2][y+1] = board[x][y] + 1;
	}
	if 
    }
    

    public static void main(String[]args){
	KnightBoard f = new KnightBoard(7,5);
	System.out.println("" + f);
    }
}
