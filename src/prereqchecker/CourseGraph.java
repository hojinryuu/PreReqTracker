package prereqchecker;

import java.util.*;

public class CourseGraph {

    private HashMap<String, ArrayList<String>> adjList;

    public CourseGraph(){
        adjList = new HashMap<>();
    }

    public HashMap<String, ArrayList<String>> getAdjList(){
        return adjList;
    }
    
    public void addCourse(String course){
        adjList.put(course, new ArrayList<String>());
    }

    public void addPreReq(String course, String preReq){
        adjList.get(course).add(preReq);
    }

    public HashSet<String> BFS(String course){

        Queue<String> queue = new LinkedList<>();
        HashSet<String> visitedCourses = new HashSet<>();

        queue.offer(course);
        visitedCourses.add(course);

        while(queue.size() != 0){
            String frontOfQueue = queue.poll();
            for(String visit : adjList.get(frontOfQueue)){
                if(!visitedCourses.contains(visit)){
                    queue.add(visit);
                    visitedCourses.add(visit);
                }
            }
        }
        return visitedCourses;
    }
}




