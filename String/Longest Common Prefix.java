// Optimal

class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    break;
                }
            }
        }
        System.out.println(prefix);
    }
}

// Brute

// import java.util.Arrays;

// class LongestCommonPrefix {
// public static void main(String[] args) {
// String[] strs = { "flower", "flow", "flight" };

// String result = "";
// Arrays.sort(strs);

// for (int i = 0; i < strs[0].length(); i++) {
// if (strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
// result += strs[0].charAt(i);
// } else {
// break;
// }
// }

// System.out.println(result);
// }
// }
