class Solution {
    public int minBitFlips(int start, int goal) {
        int ans=0;
        int sor= start^goal;
        while(sor>0){
            if((sor&1)==1)ans++;
            sor=sor>>1;
        }
        return ans;
    }
}
