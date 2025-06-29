class QuickSort {
    public static void main(String[] args) {
        int[] nums = { 13, 46, 24, 52, 20, 9 };

        int low = 0;
        int high = nums.length - 1;

        quickSort(nums, low, high);

        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] nums, int low, int high) {

        if (low < high) {
            int pIndex = partition(nums, low, high);

            quickSort(nums, low, pIndex - 1);
            quickSort(nums, pIndex + 1, high);
        }
    }

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (nums[i] <= pivot && i <= high - 1) {
                i++;
            }
            while (nums[j] > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                swap(i, j, nums);
            }
        }

        swap(low, j, nums);

        return j;
    }

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}

// Time Complexity = O(n*logn)
