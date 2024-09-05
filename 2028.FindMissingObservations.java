class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int ans[]= new int[n];
        mean=mean*(n+rolls.length);
        int rsum=0;
        for(int curr: rolls){
            rsum+=curr;
        }
        int nsum=mean-rsum;
        boolean alt=false;
        int ptr=0;
        while(nsum!=0){
            ans[ptr]++;
            if(ans[ptr]>6){
                return new int[0];
            }
            nsum--;
            if(ptr==n-1){
                alt=true;
            }
            ptr=(ptr+1)%n;

        }
        if(alt==false){
            return new int[0];
        }
        return ans;
        
    }
}
