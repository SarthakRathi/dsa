// Optimal

class Permutation {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 1 };

        int index = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            int start = 0;
            int end = nums.length - 1;
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        } else {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[index]) {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    break;
                }
            }

            int start = index + 1;
            int end = nums.length - 1;
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        for (int i : nums) {
            System.out.println(i);
        }
    }

}

// Time Complexity = O(3n)
// Time Complexity = O(1)