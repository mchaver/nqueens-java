package nqueens;

import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class ExecutionPlan {
    @Param({ "1", "2", "3", "4", "5", "6", "7" , "8" , "9", "10" })
    public int iterations;
}
