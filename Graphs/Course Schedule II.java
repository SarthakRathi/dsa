import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisiteCourse = prereq[1];
            adj.get(prerequisiteCourse).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] result = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            int currentCourse = q.poll();
            result[idx++] = currentCourse;

            for (int neighborCourse : adj.get(currentCourse)) {
                indegree[neighborCourse]--;

                if (indegree[neighborCourse] == 0) {
                    q.add(neighborCourse);
                }
            }
        }
        if (idx == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}