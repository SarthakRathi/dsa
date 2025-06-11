// Optimal Method

class ShiftZero {
    public static void main(String[] args) {

        int[] nums = { 2, 1 };

        if (nums.length > 1) {

            int j = -1;
            boolean flag = false;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    flag = true;
                    j = i;
                    break;
                }
            }

            if (flag) {
                for (int i = j + 1; i < nums.length; i++) {
                    if (nums[i] != 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        j++;
                    }
                }
            }
        }

        print(nums);
    }

    public static void print(int nums[]) {
        for (int i : nums) {
            System.out.print(i);
        }
        System.out.println();
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)

// Bruteforce Method

// import java.util.ArrayList;

// class ShiftZero {
// public static void main(String[] args) {

// int[] nums = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };

// ArrayList<Integer> temp = new ArrayList<>();

// for (int i = 0; i < nums.length; i++) {
// if (nums[i] != 0) {
// temp.add(nums[i]);
// }
// }

// for (int i = 0; i < temp.size(); i++) {
// nums[i] = temp.get(i);
// }

// for (int i = temp.size(); i < nums.length; i++) {
// nums[i] = 0;
// }

// print(nums);
// }

// public static void print(int nums[]) {
// for (int i : nums) {
// System.out.print(i);
// }
// System.out.println();
// }
// }

// Time Complexity: O(2n)
// Space Complexity: O(n)