public class Driver{
    public static void main(String[]s){
	MazeSolver f = new MazeSolver("d.txt");
	System.out.println(f.maz()+"\n\n");
	f.solve();
	System.out.println(f.maz()+"");
    }
}
