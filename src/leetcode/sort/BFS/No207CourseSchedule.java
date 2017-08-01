package leetcode.sort.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liucong
 * @ClassName: No207CourseSchedule
 * @Description:
 * @date 2017年03月22日 下午5:10
 **/
public class No207CourseSchedule {
//    if(prerequisites == null){
//        throw new IllegalArgumentException("illegal prerequisites array");
//    }
//
//    int len = prerequisites.length;
//
//    if(numCourses == 0 || len == 0){
//        return true;
//    }
//
//    // counter for number of prerequisites
//    int[] pCounter = new int[numCourses];
//    for(int i=0; i<len; i++){
//        pCounter[prerequisites[i][0]]++;
//    }
//
//    //store courses that have no prerequisites
//    LinkedList<Integer> queue = new LinkedList<Integer>();
//    for(int i=0; i<numCourses; i++){
//        if(pCounter[i]==0){
//            queue.add(i);
//        }
//    }
//
//    // number of courses that have no prerequisites
//    int numNoPre = queue.size();
//
//    while(!queue.isEmpty()){
//        int top = queue.remove();
//        for(int i=0; i<len; i++){
//            // if a course's prerequisite can be satisfied by a course in queue
//            if(prerequisites[i][1]==top){
//                pCounter[prerequisites[i][0]]--;
//                if(pCounter[prerequisites[i][0]]==0){
//                    numNoPre++;
//                    queue.add(prerequisites[i][0]);
//                }
//            }
//        }
//    }
//
//    return numNoPre == numCourses;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null)
            throw new IllegalArgumentException("illegal prerequisites array");
        int edgeNum = prerequisites.length;
        if(numCourses==0||edgeNum==0)
            return true;
        int[] pCounter = new int[numCourses];
        for (int i = 0; i < edgeNum; i++) {
            pCounter[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(pCounter[i]==0)
                queue.add(i);
        }
        int numNoPre = queue.size();

        while (!queue.isEmpty()){
            int top = queue.poll();

            for (int i = 0; i < edgeNum; i++) {
                if(prerequisites[i][1]==top){
                    pCounter[prerequisites[i][0]]--;
                    if(pCounter[prerequisites[i][0]]==0){
                        numNoPre++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return numNoPre==numCourses;
    }
}
