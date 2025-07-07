class MedianTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };

        int low = 0;
        int high = nums1.length;
        int pick = (nums1.length + nums2.length + 1) / 2;

        while (high >= low) {
            int mid1 = (low + high) / 2;
            int mid2 = pick - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if (mid1 - 1 >= 0)
                l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = nums2[mid2 - 1];
            if (mid1 < nums1.length)
                r1 = nums1[mid1];
            if (mid2 < nums2.length)
                r2 = nums2[mid2];

            if (l1 <= r2 && l2 <= r1) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    System.out.println((Math.max(l1, l2) + Math.min(r1, r2)) / 2);
                } else {
                    System.out.println(Math.max(l1, l2));
                }
                break;
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
    }
}
