class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        if(nums.length<=4)return 0;
        int ans=Integer.MAX_VALUE;

        ans=Math.min(nums[nums.length-1-3]-nums[0],ans);
        ans=Math.min(nums[nums.length-1-2]-nums[1],ans);
        ans=Math.min(nums[nums.length-1-1]-nums[2],ans);
        ans=Math.min(nums[nums.length-1]-nums[3],ans);
        return ans;
    }
}
