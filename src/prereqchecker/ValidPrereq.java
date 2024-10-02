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
 * ValidPreReqInputFile name is passed through the command line as args[1]
 * Read from ValidPreReqInputFile with the format:
 * 1. 1 line containing the proposed advanced course
 * 2. 1 line containing the proposed prereq to the advanced course
 * 
 * Step 3:
 * ValidPreReqOutputFile name is passed through the command line as args[2]
 * Output to ValidPreReqOutputFile with the format:
 * 1. 1 line, containing either the word "YES" or "NO"
 */
public class ValidPrereq {
    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.ValidPrereq <adjacency list INput file> <valid prereq INput file> <valid prereq OUTput file>");
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

        StdIn.setFile(args[1]);
        String course1 = StdIn.readString();
        String course2 = StdIn.readString();
    
        StdOut.setFile(args[2]);
        if(courseGraph.BFS(course2).contains(course1)){
            StdOut.print("NO");
        } else if (!courseGraph.getAdjList().containsKey(course1) || !courseGraph.getAdjList().containsKey(course2)){
            StdOut.print("NO");
        } else {
            StdOut.print("YES");
        }
    }
}
