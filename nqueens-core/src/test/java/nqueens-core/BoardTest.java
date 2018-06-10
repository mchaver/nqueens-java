package nqueens;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
 
class BoardTest {    
    @Test
    void toJSONTest() {
	BruteForceSolver ns = new BruteForceSolver(1,false);
	Board b = new Board(3);
	assertEquals("[[0,0,0],[0,0,0],[0,0,0]]", Board.toJSON(b));
    }
}
