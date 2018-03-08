public class USACO{

    public static int bronzeHO(int R, int C, int N, int[][] P){
	int max = 0;
	int may = 0;
	for(int x = R-1; x < R+2; x++){
	    for(int y = C-1; y < C-2; y++)
		if(P[x][y] >= P[max][may]){
		    max = x;
		    may = y;
		}
	}
	return bronzeO(R,C,N,P,max,may);
    }


    public static int bronzeO(int R, int C, int N, int[][] P, int Rm, int Cm){
	if(N == 0){
	    
	}
    }
    
    

    
}
