package nqueens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @author      mchaver
 * @version     0.2.0
 * @since       0.1.0
 */

public class NaiveSolver {
    final int size;
    final ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>();
    final ArrayList<ArrayList<ArrayList<Integer>>> solutions = new ArrayList<ArrayList<ArrayList<Integer>>>();
    boolean noThreeInLineConstraint;

    /**
     * Find all of the solutions for a particular size. 
     * 
     * 
     * @param size the dimensions, or the N value, of the N-Queens board you want to solve.
     * 
     * @param noThreeInLineConstraint if false then solve the traditional N-Queens problem,
     * if true then solve with the no-three-in-line constraint.
     */
    public NaiveSolver(int size, boolean noThreeInLineConstraint) {
	this.size = size;
	this.noThreeInLineConstraint = noThreeInLineConstraint;

	for (int i = 0; i < size; i++) {
	    board.add(new ArrayList<Integer>(Collections.nCopies(size, 0)));
	}

	for (ArrayList<Integer> row: board) {
	    String listString = row.stream().map(Object::toString)
		.collect(Collectors.joining(", "));
	}

	solve(board, 0);
    }

    static ArrayList<ArrayList<Integer>> copy(ArrayList<ArrayList<Integer>> input) {
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

    void addSolution(ArrayList<ArrayList<Integer>> b) {
	this.solutions.add(copy(b));
    }
    
    public void solve(ArrayList<ArrayList<Integer>> b, int col) {
	// all the queens are in the correct place

	if (col < size) {
	    for (int i = 0; i < size; i++) {
		if (isSafe(i, col)) {
		    b.get(i).set(col, 1);		    
		    if (col == size - 1) {
			addSolution(b);
			b.get(i).set(col, 0);
		    } else {
			// solve for the next column
			solve(b, col+1);
			// backtrack by setting the current row to 0
			// then try the next row
			b.get(i).set(col, 0);
		    }
		}
	    }
	}
    }
    
    /**
     *
     * Check if a queen is safe. It cannot be captured in a single move.
     *
     */
    boolean isSafe(int row, int col) {
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

	// check if there are three pieces in a line from the current position
	// to the left
	if (noThreeInLineConstraint && col > 1) {
	    int col0, row0, col1, row1;

	    for (col0 = 0; col0 < col - 1; col0++) {
		for (row0 = 0; row0 < size; row0++) {
		    
		    if (board.get(row0).get(col0) == 1) {
			for (col1 = col0 + 1; col1 < col; col1++) {
			    for (row1 = 0; row1 < size; row1++) {
				
				if (board.get(row1).get(col1) == 1) {
				    if ((col0 - col1) * (row0 - row) == (col0 - col) * (row0 - row1)) {
					return false;
				    }
				}
			    }
			}
		    }
		}
	    }
	}
 
        return true;
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
