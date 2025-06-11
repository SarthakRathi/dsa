//Optimal

class LongestSubarray {
    public static void main(String[] args) {
        int[] nums = { 2, 0, 0, 3 };
        // int[] nums = { 1, 2, 3, 1, 1, 1, 1, 4, 2, 3 };
        int s = 3;

        int left = 0;
        int sum = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (s < sum && left <= right) {
                sum -= nums[left];
                left++;
            }
            if (s == sum) {
                if (maxLength < right - left + 1) {
                    maxLength = right - left + 1;
                }
            }
        }
        System.out.println(maxLength);
    }
}

// Time Complexity = O(2n)
// Space Complexity = O(1)

// Better

// import java.util.HashMap;
// import java.util.Map;

// class LongestSubarray {
// public static void main(String[] args) {
// int[] nums = { 2, 0, 0, 3 };
// int s = 3;

// int sum = 0;
// int length = 0;
// int temp = 0;

// Map<Integer, Integer> hash = new HashMap<>();
// for (int i = 0; i < nums.length; i++) {

// sum += nums[i];

// if (hash.containsKey(sum - s)) {
// temp = i - hash.get(sum - s);
// }

// if (temp > length) {
// length = temp;
// }

// if (!hash.containsKey(sum)) {
// hash.put(sum, i); // For zeroes
// }
// }
// System.out.println(length);
// }
// }

// Time Complexity = O(n2)
// Space Complexity = O(n)

// Bruteforce

// class LongestSubarray {
// public static void main(String[] args) {
// int[] nums = { 1, 2, 3, 1, 1, 1, 1, 4, 2, 3 };
// int s = 4;

// int max = 0;
// int sum = 0;
// int count = 0;

// for (int i = 0; i < nums.length; i++) {
// count = 0;
// sum = 0;
// for (int j = i; j < nums.length; j++) {
// sum += nums[j];
// count++;
// if (sum == s) {
// if (max < count) {
// max = count;
// }
// }
// }
// }
// System.out.print(max);
// }
// }

// Time Complexity = O(n**2)
// Space Complexity = O(1)
