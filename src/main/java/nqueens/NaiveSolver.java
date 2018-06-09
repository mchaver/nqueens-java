package nqueens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class NaiveSolver {
    private int size;
    private ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>();
    private ArrayList<ArrayList<ArrayList<Integer>>> solutions = new ArrayList<ArrayList<ArrayList<Integer>>>();
    
    public NaiveSolver(int size) {
	this.size = size;

	for (int i = 0; i < size; i++) {
	    board.add(new ArrayList<Integer>(Collections.nCopies(size, 0)));
	}

	for (ArrayList<Integer> row: board) {
	    String listString = row.stream().map(Object::toString)
		.collect(Collectors.joining(", "));
	}

	solve();
    }

    private static ArrayList<ArrayList<Integer>> copy(ArrayList<ArrayList<Integer>> input) {
	ArrayList<ArrayList<Integer>> copy = new ArrayList<ArrayList<Integer>>(input.size());
	for (int i = 0; i < input.size(); i++) {
	    ArrayList<Integer> row = input.get(i);
	    copy.add(new ArrayList<Integer>(row.size())); // add internal array initialization
	    for (int j = 0; j < row.size(); j++) {
		copy.get(i).add(row.get(j)); // actually copy value into new array
	    }
	}
	return copy;
    }

    private void addSolution(ArrayList<ArrayList<Integer>> b) {
	this.solutions.add(copy(b));
    }
    
    public void solveAux(ArrayList<ArrayList<Integer>> bb, int col) {
	// all the queens are in the correct place

	if (col < size) {
	    for (int i = 0; i < size; i++) {
		// board.get(i).set(col, 1);
		// System.out.println(board.get(i).get(col));
		if (isSafe(i, col)) {
		    bb.get(i).set(col, 1);
		    
		    if (col == size - 1) {
			addSolution(bb);
			bb.get(i).set(col, 0);
		    } else {
			solveAux(bb, col+1);
			// backtrack
			bb.get(i).set(col, 0);
		    }
		}
	    }
	}
    }

    // check if safe just on the left side
    private boolean isSafe(int row, int col) {
	int i, j;
 
        // check this row on left side
        for (i = 0; i < col; i++) {
            if (board.get(row).get(i) == 1) {
                return false;
	    }
	}
 
        // check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).get(j) == 1) {
                return false;
	    }
	}
 
        // check lower diagonal on left side
        for (i = row, j = col; j >= 0 && i < size; i++, j--) {
            if (board.get(i).get(j) == 1) {
                return false;
	    }
	}
 
        return true;
    }

    private void solve() {
	solveAux(board, 0);
    }

    public void printSolutions() {
	for (ArrayList<ArrayList<Integer>> solution: solutions) {
	    for (ArrayList<Integer> row: solution) {
		String listString = row.stream().map(Object::toString)
		    .collect(Collectors.joining(", "));
		System.out.println(listString);
	    }
	    System.out.println("");
	}
    }

    public ArrayList<ArrayList<ArrayList<Integer>>> getSolutions() {
	return solutions;
    }

}
