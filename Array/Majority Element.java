// Optimal

class Majority {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 3 };

        int count = 0;
        int element = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                element = nums[i];
            } else if (nums[i] == element) {
                count++;
            } else {
                count--;
            }
        }
        System.out.println(element);
    }
}

// Time Complexity = O(n)
// Space Complexity = O(1)

// Better

// import java.util.HashMap;
// import java.util.Map;

// class Majority {
// public static void main(String[] args) {
// int[] nums = { 3, 2, 3 };

// Map<Integer, Integer> hash = new HashMap<>();

// for (int i = 0; i < nums.length; i++) {
// if (hash.containsKey(nums[i])) {
// hash.put(nums[i], hash.get(nums[i]) + 1);
// } else {
// hash.put(nums[i], 1);
// }
// }

// for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
// if (entry.getValue() > nums.length / 2) {
// System.out.println(entry.getKey());
// }
// }
// }
// }

// Time Complexity = O(n)
// Space Complexity = O(n)