package nqueens;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
class NaiveSolverTest {
    ArrayList<ArrayList<Integer>> arrayToArrayList(Integer[][] as) {
	ArrayList<ArrayList<Integer>> copy = new ArrayList<ArrayList<Integer>>(as.length);

	for (int i = 0; i < as.length; i++) {
	    copy.add(new ArrayList<Integer>(as[i].length));
	    for (int j = 0; j < as[i].length; j++) {
		copy.get(i).add(as[i][j]);
	    }
	}

	return copy;
    }
    
    @Test
    void sizeOneTest() {
	NaiveSolver ns = new NaiveSolver(1);
	ArrayList<ArrayList<ArrayList<Integer>>> solutions = ns.getSolutions();
		
	assertEquals(1, solutions.size());

	Integer[][] as0 = {{1}};
	ArrayList<ArrayList<Integer>> s0 = arrayToArrayList(as0);

	assertTrue(solutions.contains(s0));
    }

    @Test
    void sizeTwoTest() {
	NaiveSolver ns = new NaiveSolver(2);
	ArrayList<ArrayList<ArrayList<Integer>>> solutions = ns.getSolutions();
		
	assertEquals(0, solutions.size());
    }

    @Test
    void sizeThreeTest() {
    	NaiveSolver ns = new NaiveSolver(3);
    	ArrayList<ArrayList<ArrayList<Integer>>> solutions = ns.getSolutions();
		
    	assertEquals(0, solutions.size());
    }

    @Test
    void sizeFourTest() {
    	NaiveSolver ns = new NaiveSolver(4);
    	ArrayList<ArrayList<ArrayList<Integer>>> solutions = ns.getSolutions();
		
    	assertEquals(2, solutions.size());
	
	Integer[][] as0 = {{0,0,1,0},{1,0,0,0},{0,0,0,1},{0,1,0,0}};
	ArrayList<ArrayList<Integer>> s0 = arrayToArrayList(as0);

	assertTrue(solutions.contains(s0));

	Integer[][] as1 = {{0,1,0,0},{0,0,0,1},{1,0,0,0},{0,0,1,0}};
	ArrayList<ArrayList<Integer>> s1 = arrayToArrayList(as1);

	assertTrue(solutions.contains(s1));
    }

    @Test
    void sizeEightTest() {
    	NaiveSolver ns = new NaiveSolver(8);
    	ArrayList<ArrayList<ArrayList<Integer>>> solutions = ns.getSolutions();
		
    	assertEquals(92, solutions.size());

	Integer[][] as0 = {{0,0,0,1,0,0,0,0},{0,0,0,0,0,0,1,0},{0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1},{0,1,0,0,0,0,0,0},{0,0,0,0,1,0,0,0},{1,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0}};
	ArrayList<ArrayList<Integer>> s0 = arrayToArrayList(as0);

	assertTrue(solutions.contains(s0));

    }

    @Test
    void sizeTenTest() {
    	NaiveSolver ns = new NaiveSolver(10);
    	ArrayList<ArrayList<ArrayList<Integer>>> solutions = ns.getSolutions();
		
    	assertEquals(724, solutions.size());
    }
}
