    class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int sum = 0;
        int cnt = 0;
        
        for (int num : nums) {
            if (num == 0) {
                cnt++;
            }
            sum += num;
        }
        if(Math.abs(target)>sum)return 0;
        if ((target + sum) % 2 != 0)
            return 0;
        int t = (target + sum) / 2;
        int[][] dp = new int[nums.length][t + 1];
        Arrays.sort(nums);
        int zc=(int)Math.pow(2,cnt);
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = zc;
        }

        if (cnt==0 && nums[0] <= t) {
            dp[0][nums[0]] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length - 1][dp[0].length - 1];

    }
}
