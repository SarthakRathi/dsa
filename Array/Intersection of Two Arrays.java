import java.util.HashSet;
import java.util.Set;

class Intersection {
    public static void main(String[] args) {

        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                intersect.add(num);
            }
        }
        System.out.print(intersect);
    }
}
