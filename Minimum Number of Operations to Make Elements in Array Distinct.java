class Solution {
    public int minimumOperations(int[] nums) {
        int[] cnt=new int[101];
        int br=-1;
        for(int i=nums.length-1; i>=0; i--){
            cnt[nums[i]]++;
            if(cnt[nums[i]]>=2){
                br=i;
                break;
            }
        }

        if(br==-1)return 0;
        if((br+1)%3==0)return (br+1)/3;
        return (br+1)/3 +1;
    }
}
