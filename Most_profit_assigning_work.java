class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int ans=0;
        for(int i=0; i<worker.length; i++){
            int pro=0;
            for(int j=0; j<difficulty.length; j++){
                if(difficulty[j]<=worker[i]){
                    pro=Math.max(profit[j], pro);
                }
            }

            ans=ans+pro;
        }

        return ans;
    }
}