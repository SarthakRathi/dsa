import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0)
            return res;
        backtrack(res, num, target, 0, 0, 0, "");
        return res;
    }

    private void backtrack(List<String> res, String num, int target, int pos, long eval, long multed, String path) {
        if (pos == num.length()) {
            if (eval == target) {
                res.add(path);
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0')
                break;
            String currStr = num.substring(pos, i + 1);
            long curr = Long.parseLong(currStr);
            if (pos == 0) {
                backtrack(res, num, target, i + 1, curr, curr, currStr);
            } else {
                backtrack(res, num, target, i + 1, eval + curr, curr, path + "+" + currStr);
                backtrack(res, num, target, i + 1, eval - curr, -curr, path + "-" + currStr);
                backtrack(res, num, target, i + 1, eval - multed + multed * curr, multed * curr, path + "*" + currStr);
            }
        }
    }
}

// Time Complexity = O(4^n)
// Space Complexity = O(M.n)