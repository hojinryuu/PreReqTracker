package prereqchecker;

// import java.util.*;

/**
 * Steps to implement this class main method:
 * 
 * Step 1:
 * AdjListInputFile name is passed through the command line as args[0]
 * Read from AdjListInputFile with the format:
 * 1. a (int): number of courses in the graph
 * 2. a lines, each with 1 course ID
 * 3. b (int): number of edges in the graph
 * 4. b lines, each with a source ID
 * 
 * Step 2:
 * AdjListOutputFile name is passed through the command line as args[1]
 * Output to AdjListOutputFile with the format:
 * 1. c lines, each starting with a different course ID, then 
 *    listing all of that course's prerequisites (space separated)
 */
public class AdjList {
    public static void main(String[] args) {

        if ( args.length < 2 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.AdjList <adjacency list INput file> <adjacency list OUTput file>");
            return;
        }

	    // WRITE YOUR CODE HERE
        CourseGraph courseGraph = new CourseGraph();
     
        StdIn.setFile(args[0]);
        int numCourses = StdIn.readInt();

        for(int i = 0; i < numCourses; i++){
            String course = StdIn.readString();
            courseGraph.addCourse(course);
        }

        int numPreReq = StdIn.readInt();

        for(int i = 0; i < numPreReq; i++){
            String course = StdIn.readString();
            String preReq = StdIn.readString();
            courseGraph.addPreReq(course, preReq);
        }

        StdOut.setFile(args[1]);

        for (String course : courseGraph.getAdjList().keySet()) {
            StdOut.print(course + " ");
            for (String preReq : courseGraph.getAdjList().get(course)) {
                StdOut.print(preReq + " ");
            }
            StdOut.println();
        }
    }
}
