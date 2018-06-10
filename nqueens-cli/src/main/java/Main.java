package nqueens;

import java.util.ArrayList;
import org.apache.commons.cli.*;

public class Main {
    public static void main(String[] args) {
	Options options = new Options();
	Option input = new Option("n", true, "size of N-Queens board to solve");
	input.setRequired(false);
        options.addOption(input);
       
	Option lineTest = new Option("l", false, "Add no-three-in-line constraint to N-Queens problem");
	lineTest.setRequired(false);
        options.addOption(lineTest);

	Option help = new Option("help", "print this message");
	help.setRequired(false);
        options.addOption(help);
	
	CommandLineParser parser = new DefaultParser();
	HelpFormatter formatter = new HelpFormatter();
	CommandLine cmd = null;
        try {
	    cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("nqueens-cli", options);

            System.exit(1);
        }

	if (cmd.hasOption("help") || !cmd.hasOption("n")) {
            formatter.printHelp("nqueens-cli", options);
	} else {
	    String ns = cmd.getOptionValue("n");
	    Integer n = Integer.parseInt(ns);

	    if (n > 0) {
		boolean noThreeLineConstraint = cmd.hasOption("l");
		BruteForceSolver solver = new BruteForceSolver(n, noThreeLineConstraint);
		ArrayList<ArrayList<ArrayList<Integer>>> solutions = solver.getSolutions();

		String there = "";

		if (solutions.size() == 1) {
		    there = "There is ";
		} else {
		    there = "There are ";
		}

		String problem = "";

		if (noThreeLineConstraint) {
		    problem = "N-Queens Problem with no-three-in-line constraint";
		} else {
		    problem = "N-Queens Problem with";
		}
	    
		System.out.println();	    
		System.out.println(there + String.valueOf(solutions.size()) + " solutions for the " + problem + " when N = " + String.valueOf(n) + ":");
		System.out.println();
		System.out.println(solver.solutionsToString());
	    } else {
		System.out.println("n must be greater than 0");
	    }
	}
    }
}
