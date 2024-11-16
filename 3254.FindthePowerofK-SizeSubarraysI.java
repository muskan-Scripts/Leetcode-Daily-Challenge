class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if(k==1){
            return nums;
        }
        int[] ans= new int[nums.length-k+1];
        for(int i=0; i<ans.length; i++ ){
            int max= nums[i];
            for(int j=i+1; j<i+k; j++){
                if(nums[j]==max+1){
                   max=nums[j];
                }
                else{
                    max=-1;
                    break;
                }
            }

            ans[i]=max;
        }
        return ans;
    }
}
