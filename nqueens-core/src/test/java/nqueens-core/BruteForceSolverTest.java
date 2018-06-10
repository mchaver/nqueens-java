package nqueens;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
class BruteForceSolverTest {    
    @Test
    void sizeOneTest() {
	BruteForceSolver ns = new BruteForceSolver(1,false);
	ArrayList<ArrayList<ArrayList<Integer>>> solutions = ns.getSolutions();
	assertEquals(1, solutions.size());

	Integer[][] as0 = {{1}};
	ArrayList<ArrayList<Integer>> s0 = Utils.arrayToArrayList(as0);

	assertTrue(solutions.contains(s0));
    }

    @Test
    void sizeTwoTest() {
	BruteForceSolver ns = new BruteForceSolver(2,false);
	ArrayList<ArrayList<ArrayList<Integer>>> solutions = ns.getSolutions();		
	assertEquals(0, solutions.size());
    }

    @Test
    void sizeThreeTest() {
    	BruteForceSolver ns = new BruteForceSolver(3,false);
    	ArrayList<ArrayList<ArrayList<Integer>>> solutions = ns.getSolutions();		
    	assertEquals(0, solutions.size());
    }

    @Test
    void sizeFourTest() {
    	BruteForceSolver ns = new BruteForceSolver(4,false);
    	ArrayList<ArrayList<ArrayList<Integer>>> solutions = ns.getSolutions();
    	assertEquals(2, solutions.size());
	
	Integer[][] as0 = {{0,0,1,0},{1,0,0,0},{0,0,0,1},{0,1,0,0}};
	ArrayList<ArrayList<Integer>> s0 = Utils.arrayToArrayList(as0);

	assertTrue(solutions.contains(s0));

	Integer[][] as1 = {{0,1,0,0},{0,0,0,1},{1,0,0,0},{0,0,1,0}};
	ArrayList<ArrayList<Integer>> s1 = Utils.arrayToArrayList(as1);

	assertTrue(solutions.contains(s1));
    }

    @Test
    void sizeFiveTest() {
    	BruteForceSolver ns = new BruteForceSolver(5,false);
    	ArrayList<ArrayList<ArrayList<Integer>>> solutions = ns.getSolutions();
    	assertEquals(10, solutions.size());
    }

    @Test
    void sizeSixTest() {
    	BruteForceSolver ns = new BruteForceSolver(6,false);
    	ArrayList<ArrayList<ArrayList<Integer>>> solutions = ns.getSolutions();
    	assertEquals(4, solutions.size());
    }

    @Test
    void sizeEightTest() {
    	BruteForceSolver ns = new BruteForceSolver(8,false);
    	ArrayList<ArrayList<ArrayList<Integer>>> solutions = ns.getSolutions();		
    	assertEquals(92, solutions.size());

	Integer[][] as0 = {{0,0,0,1,0,0,0,0},{0,0,0,0,0,0,1,0},{0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1},{0,1,0,0,0,0,0,0},{0,0,0,0,1,0,0,0},{1,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0}};
	ArrayList<ArrayList<Integer>> s0 = Utils.arrayToArrayList(as0);

	assertTrue(solutions.contains(s0));
    }

    @Test
    void sizeTenTest() {
    	BruteForceSolver ns = new BruteForceSolver(10,false);
    	ArrayList<ArrayList<ArrayList<Integer>>> solutions = ns.getSolutions();		
    	assertEquals(724, solutions.size());
    }

    @Test
    void lineConstraintSizeFourTest() {
    	BruteForceSolver ns = new BruteForceSolver(8,true);
    	ArrayList<ArrayList<ArrayList<Integer>>> solutions = ns.getSolutions();

    	assertTrue(solutions.size() < 92);
	
	Integer[][] as0 = {{0,0,0,0,0,1,0,0},{0,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,0},{1,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,0},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,0},{0,0,1,0,0,0,0,0}};
	ArrayList<ArrayList<Integer>> s0 = Utils.arrayToArrayList(as0);

	assertTrue(solutions.contains(s0));

	Integer[][] as1 = {{0,0,0,1,0,0,0,0},{0,0,0,0,0,0,1,0},{0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1},{0,1,0,0,0,0,0,0},{0,0,0,0,1,0,0,0},{1,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0}};
	ArrayList<ArrayList<Integer>> s1 = Utils.arrayToArrayList(as1);
	assertFalse(solutions.contains(s1));
    }
}
