//Optimal

class Missing {
    public static void main(String[] args) {
        int[] nums = { 3, 0, 1 };

        int xor1 = 0;
        int xor2 = 0;

        for (int i = 0; i < nums.length; i++) {
            xor2 = xor2 ^ nums[i];
            xor1 = xor1 ^ i;
        }
        xor1 = xor1 ^ nums.length;

        System.out.println(xor1 ^ xor2);
    }
}

// Time Complexity = O(n)
// Space Complexity = O(1)

// Optimal

// class Missing {
// public static void main(String[] args) {
// int[] nums = { 3, 0, 1 };

// int n = nums.length;
// int sum = (n * (n + 1)) / 2;
// int numsum = 0;

// for (int i : nums) {
// numsum += i;
// }

// System.out.println(sum - numsum);
// }
// }

// Time Complexity = O(n)
// Space Complexity = O(1)

// Bruteforce

// import java.util.HashSet;
// import java.util.Set;

// class Missing {
// public static void main(String[] args) {
// int[] nums = { 3, 0, 1 };

// Set<Integer> snums = new HashSet<>();
// int missing;

// for (Integer integer : nums) {
// snums.add(integer);
// }

// for (int i = 0; i <= nums.length + 1; i++) {
// if (!snums.contains(i)) {
// missing = i;
// System.out.print(missing);
// break;
// }
// }
// }
// }
