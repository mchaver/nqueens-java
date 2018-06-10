package nqueens;

import org.openjdk.jmh.annotations.*;

public class BruteForceSolverBenchmark {
    // @Param({ "1", "2", "3", "4", "5", "6", "7" , "8" , "9", "20" })
    // public int arg;
    
    @Benchmark
    public void init() {
	BruteForceSolver ns = new BruteForceSolver(20,true);
    }
}
