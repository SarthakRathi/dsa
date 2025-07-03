class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = { 30, 11, 23, 4, 20 };
        int h = 5;

        int low = 1;
        int high = max(piles);
        int k = high;

        while (high >= low) {
            int mid = (low + high) / 2;
            int requiredTime = calTime(piles, mid);
            if (requiredTime <= h) {
                k = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(k);
    }

    public static int calTime(int[] piles, int mid) {
        int requiredTime = 0;
        for (int i = 0; i < piles.length; i++) {
            requiredTime += Math.ceil((double) piles[i] / mid);
        }
        return requiredTime;
    }

    public static int max(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
