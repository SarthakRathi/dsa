class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int[] hash = new int[128];
        int l = 0;
        int r = 0;
        int minLen = Integer.MAX_VALUE;
        int sIndex = -1;
        int count = 0;
        int n = s.length();
        int m = t.length();

        for (char c : t.toCharArray()) {
            hash[c]++;
        }

        while (r < n) {
            char c = s.charAt(r);
            if (hash[c] > 0) {
                count++;
            }
            hash[c]--;
            while (count == m) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }
                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0)
                    count--;
                l++;
            }
            r++;
        }
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }
}

// Time Complexity = O(n)
// Space Complexity = O(128)