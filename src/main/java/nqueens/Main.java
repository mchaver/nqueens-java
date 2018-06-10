package nqueens;

public class Main {
    public static void main(String[] args) {
	BruteForceSolver solver = new BruteForceSolver(8,false);
	System.out.println(solver.solutionsToString());
    }
}
