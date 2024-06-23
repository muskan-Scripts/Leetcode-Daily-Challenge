import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // Map to store the count of prefix sums
        Map<Integer, Integer> prefixCounts = new HashMap<>();
        // Initialize the map with a base case
        prefixCounts.put(0, 1);

        int prefixSum = 0;
        int result = 0;

        for (int num : nums) {
            // Increment prefixSum by 1 if the current number is odd
            prefixSum += num % 2;

            // Check if there's a prefix sum that would result in exactly k odd numbers
            result += prefixCounts.getOrDefault(prefixSum - k, 0);

            // Increment the count of the current prefix sum in the map
            prefixCounts.put(prefixSum, prefixCounts.getOrDefault(prefixSum, 0) + 1);
        }

        return result;
    }
}
