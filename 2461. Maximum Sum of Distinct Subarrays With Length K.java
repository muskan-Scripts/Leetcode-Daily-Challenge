import java.util.HashSet;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        long Sum = 0;
        long ans = 0;
        int st = 0;

        for (int i = 0; i < nums.length; i++) {
            while (set.contains(nums[i]) || set.size() == k) {
                set.remove(nums[st]);
                Sum -= nums[st];
                st++;
            }

            set.add(nums[i]);
            Sum += nums[i];

            if (set.size() == k) {
                ans = Math.max(Sum, ans);
            }
        }

        return ans;
    }
}
