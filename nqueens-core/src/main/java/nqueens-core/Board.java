package nqueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author      mchaver
 * @version     0.4.0
 * @since       0.4.0
 */

public class Board {
    int size;
    int[][] board;

    /**
     * Create a board of equal height and width.
     * 
     * 
     * @param size should be 1 or greater.
     */
    public Board(int size) {
	this.size = size;
	board = new int[size][size];
	
	for (int[] row: board)
	    Arrays.fill(row, 0);
    }

    // getters
    
    public int[][] getBoard() {
	return board;
    }

    public int getSize() {
	return size;
    }

    /**
     *
     * convert a board to an ArrayList<ArrayList<Integer>>
     */

    public static ArrayList<ArrayList<Integer>> toArrayList(int[][] b) {
	ArrayList<ArrayList<Integer>> copy = new ArrayList<ArrayList<Integer>>(b.length);

	for (int i = 0; i < b.length; i++) {
	    copy.add(new ArrayList<Integer>(b[i].length));
	    for (int j = 0; j < b[i].length; j++) {
		copy.get(i).add(b[i][j]);
	    }
	}

	return copy;
    }
    
    /**
     * 
     * convert a board to a readable String.
     */
    public static String toString(int[][] b) {
	StringBuilder sb = new StringBuilder(64);
	for (int[] row: b) {
	    String listString = Arrays.stream(row).mapToObj(i -> ((Integer) i).toString())
		.collect(Collectors.joining(", "));
	    sb.append(listString);
	    sb.append("\n");
	}
	return sb.toString();
    }

    /**
     * 
     * convert a board to a JSON array.
     */
    public static String toJSON(Board bb) {
	int[][] b = bb.getBoard();
	int s = bb.getSize();
	StringBuilder sb = new StringBuilder(64);
	sb.append("[");
	int j = 0;
	for (int[] row: b) {
	    sb.append("[");
	    String listString = Arrays.stream(row).mapToObj(i -> ((Integer) i).toString())
		.collect(Collectors.joining(","));
	    sb.append(listString);
	    sb.append("]");
	    if (j < s - 1) {
		sb.append(",");
	    }
	    j++;
	}
	sb.append("]");
	return sb.toString();
    }

    // public static int[][] fromJSON(String source) {
    // 	String[] integersAsText = source.split(",");
 
    // 	int[] results = new int[ integersAsText.length ];
 
    // 	int i = 0; 
 
    // 	for (String textValue : integersAsText ) {
    // 	    results[i] = Integer.parseInt( textValue ); 
    // 	    i++; 
    // 	} 
 
    // 	return results ; 
    // }
}
