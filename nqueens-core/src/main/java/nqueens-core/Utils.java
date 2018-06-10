package nqueens;

import java.util.ArrayList;

/**
 * @author      mchaver
 * @version     0.2.0
 * @since       0.2.0
 */

public class Utils {
    /**
     *
     * Copy the values of an ArrayList<ArrayList<Integer>> and return a new ArrayList<ArrayList<Integer>>.
     * References will not be copied. Changes to the new ArrayList<ArrayList<Integer>> will not affect the old one.
     *
     */
    static ArrayList<ArrayList<Integer>> copy(ArrayList<ArrayList<Integer>> input) {
	ArrayList<ArrayList<Integer>> copy = new ArrayList<ArrayList<Integer>>(input.size());
	for (int i = 0; i < input.size(); i++) {
	    ArrayList<Integer> row = input.get(i);
	    copy.add(new ArrayList<Integer>(row.size()));
	    for (int j = 0; j < row.size(); j++) {
		copy.get(i).add(row.get(j));
	    }
	}
	return copy;
    }

    /**
     *
     * Copy the values of an Integer[][] and return a new ArrayList<ArrayList<Integer>>.
     * References will not be copied. Changes to the new ArrayList<ArrayList<Integer>> will not affect the Integer[][].
     *
     */
    static ArrayList<ArrayList<Integer>> arrayToArrayList(Integer[][] as) {
	ArrayList<ArrayList<Integer>> copy = new ArrayList<ArrayList<Integer>>(as.length);

	for (int i = 0; i < as.length; i++) {
	    copy.add(new ArrayList<Integer>(as[i].length));
	    for (int j = 0; j < as[i].length; j++) {
		copy.get(i).add(as[i][j]);
	    }
	}

	return copy;
    }

    /**
     * Int safe version of slope comparison.
     * Does not use division. This avoid division by zero errors and float comparison.
     * 
     */
    static boolean threePointsFormALine(int x0, int y0, int x1, int y1, int x2, int y2) {
	return (x0 - x1) * (y0 - y2) == (x0 - x2) * (y0 - y1);
    }
}
