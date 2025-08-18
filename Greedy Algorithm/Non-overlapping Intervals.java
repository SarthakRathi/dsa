import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int lastEnding = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= lastEnding) {
                count++;
                lastEnding = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}

// Time Complexity = O(n)
// Space Complexity = O(1)