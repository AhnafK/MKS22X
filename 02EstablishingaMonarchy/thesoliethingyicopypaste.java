public boolean solveR(int col){
    if(col == board.length)
	return true;
    for(int x = 0; x < board[0].length; x++){
	if(addQueen(col, x)){
	    if(solveR(col + 1)){
		return true;
	    }
	    else{
		removeQueen(col, x);
	    }
	}
    }
    return false;
}
