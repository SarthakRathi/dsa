class KthMissingPositive {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 7, 11 };
        int k = 5;

        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;
        boolean isPossible;

        while (high >= low) {
            int mid = (low + high) / 2;
            isPossible = isPossible(arr, mid, k);
            if (isPossible) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }

        int result = k + ans;
        System.out.println(result);
    }

    public static boolean isPossible(int[] arr, int index, int k) {
        int missingCount = arr[index] - (index + 1);
        return missingCount >= k;
    }
}

// Time Complexity = O(log2 n)