class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int empty=numBottles;
        int ans=numBottles;
        
        while(empty>=numExchange){
            int ad=empty/numExchange;
            ans=ans+ad;
            int lef=ad+empty-ad*numExchange;
            empty=lef;
        }
        return ans;
    }
}
