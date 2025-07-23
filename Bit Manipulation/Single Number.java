//Better Method

class SingleNumber {
    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2 };

        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        System.out.println(result);
    }
}

// Time Complexity = O(n)
// Space Complexity = O(1)

// Better Method

// import java.util.HashMap;
// import java.util.Map;

// class SingleNumber {
// public static void main(String[] args) {
// int[] nums = { 4, 1, 2, 1, 2 };

// Map<Integer, Integer> hash = new HashMap<>();

// for (int i = 0; i < nums.length; i++) {
// if (hash.containsKey(nums[i])) {
// hash.put(nums[i], 2);
// } else {
// hash.put(nums[i], 1);
// }
// }

// for (int i : hash.keySet()) {
// if (hash.get(i) == 1) {
// System.out.println(i);
// }
// }
// }
// }

// Time Complexity = O(2n)
// Space Complexity = O(n)

// Bruteforce Method

// class SingleNumber {
// public static void main(String[] args) {
// int[] nums = { 2, 2, 1 };
// int counter = 0;

// for (int i = 0; i < nums.length; i++) {
// for (int j = 0; j < nums.length; j++) {
// if (nums[i] == nums[j]) {
// counter++;
// }
// }
// if (counter == 1) {
// System.out.println(nums[i]);
// }
// counter = 0;
// }
// }
// }

// Time Complexity = O(n**2)
// Space Complexity = O(1)