class ReversePairs {

    static int count = 0;

    public static void main(String[] args) {
        int[] nums = { 2, 4, 3, 5, 1 };

        int low = 0;
        int high = nums.length - 1;

        mergeSort(nums, low, high);

        System.out.println(count);
    }

    public static void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);

    }

    public static void countPairs(int[] nums, int low, int mid, int high) {
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && nums[i] > 2 * nums[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int leftSize = mid - low + 1;
        int rightSize = high - mid;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            left[i] = nums[low + i];
        }
        for (int j = 0; j < rightSize; j++) {
            right[j] = nums[mid + 1 + j];
        }

        int i = 0, j = 0, k = low;

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                nums[k] = left[i];
                i++;
            } else {
                nums[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            nums[k] = left[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            nums[k] = right[j];
            j++;
            k++;
        }
    }
}

// Time Complexity = O(n*logn)
