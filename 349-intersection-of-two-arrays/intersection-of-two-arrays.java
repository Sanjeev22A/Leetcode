import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> num1Set = new HashSet<>();
        HashSet<Integer> num2Set = new HashSet<>();
        
        // Add elements of nums1 to num1Set
        for (int num : nums1) {
            num1Set.add(num);
        }

        // Add elements of nums2 to num2Set
        for (int num : nums2) {
            num2Set.add(num);
        }

        // Find the intersection
        List<Integer> result = new ArrayList<>();
        for (int num : num1Set) {
            if (num2Set.contains(num)) {
                result.add(num);
            }
        }

        // Convert the result to int[]
        int[] intersection = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersection[i] = result.get(i);
        }

        return intersection;
    }
}
