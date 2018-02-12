public boolean solveR(int row){
    if(row >= board.length)
	return true;
    for(int x = 0; x < board[0].length; x++){
	if(addQueen(row, x)){
	    if(solveR(row + 1)){
		return true;
	    }
	}
    }
    return false;
}
