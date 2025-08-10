class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int max = 0;
        int[] charIndex = new int[256];

        while (r < s.length()) {
            char c = s.charAt(r);
            l = Math.max(charIndex[c], l);
            max = Math.max(max, r - l + 1);
            charIndex[c] = r + 1;
            r++;
        }
        return max;
    }
}

// Time Complexity = O(n)
// Space Complexity = O(256)