class MergeSort {
    public static void main(String[] args) {
        int[] nums = { 13, 46, 24, 52, 20, 9 };
        int low = 0;
        int high = nums.length - 1;

        System.out.println("Original array:");
        printArray(nums);

        mergeSort(nums, low, high);

        System.out.println("Sorted array:");
        printArray(nums);
    }

    public static void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
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

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

// Time Complexity = O(n*logn)