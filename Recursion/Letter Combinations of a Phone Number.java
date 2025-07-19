import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty())
            return result;

        String[] map = {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        backtrack(digits, 0, new StringBuilder(), map, result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder path, String[] map, List<String> result) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backtrack(digits, index + 1, path, map, result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}

// Time Complexity = O(4^n)
// Space Complexity = O(n * 4^n)