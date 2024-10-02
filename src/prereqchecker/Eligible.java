package prereqchecker;

import java.util.*;

/**
 * 
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
 * EligibleInputFile name is passed through the command line as args[1]
 * Read from EligibleInputFile with the format:
 * 1. c (int): Number of courses
 * 2. c lines, each with 1 course ID
 * 
 * Step 3:
 * EligibleOutputFile name is passed through the command line as args[2]
 * Output to EligibleOutputFile with the format:
 * 1. Some number of lines, each with one course ID
 */
public class Eligible {
    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.Eligible <adjacency list INput file> <eligible INput file> <eligible OUTput file>");
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
        int numOfCourses = StdIn.readInt();
        
        HashSet<String> storedCourses = new HashSet<>();

        for (int i = 0; i < numOfCourses; i++) {
            String course = StdIn.readString();
            storedCourses.addAll(courseGraph.BFS(course));
        }

        StdOut.setFile(args[2]);
        
        for(String check : courseGraph.getAdjList().keySet()){
            HashSet<String> cloned = new HashSet<>(storedCourses); // copies the storedCourses every iteration to compare later
            for(String checkCourse : courseGraph.getAdjList().get(check)){ // hashsets can't contain duplicates
                cloned.add(checkCourse);
            }
            if(cloned.equals(storedCourses) && !storedCourses.contains(check)){ // different content -> course not elligbile                                                                           
                StdOut.println(check);
            }
        }
    }
}
