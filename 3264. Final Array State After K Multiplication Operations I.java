class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1]==b[1])return a[0]-b[0];

            return a[1]-b[1];
        });

        for(int i=0; i<nums.length; i++){
            pq.add(new int[]{i, nums[i]});
        }

        for(int i=0; i<k; i++){
            int[] curr= pq.poll();
            curr[1] = curr[1]*multiplier;
            nums[curr[0]]=curr[1];
            pq.add(curr);
        }

        return nums;

    }
}
