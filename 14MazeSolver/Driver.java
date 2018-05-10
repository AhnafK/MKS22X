public class Driver{
    public static void main(String[]d){
	MazeSolver f = new MazeSolver("################\n#S#          #E#\n#              #\n################");
	System.out.println(""+f);
	if(f.solve(1))
	    System.out.println("good");
    }
}
