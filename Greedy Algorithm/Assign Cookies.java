import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int l = g.length - 1;
        int r = s.length - 1;
        int count = 0;

        while (l >= 0 && r >= 0) {
            if (s[r] >= g[l]) {
                count++;
                r--;
            }
            l--;
        }

        return count;
    }
}

// Time Complexity = O(nlogn + mlogm)
// Space Complexity = O(1)