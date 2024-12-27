class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int res=Integer.MIN_VALUE;

        int var=values[0];
        for(int i=1; i<values.length; i++){
            
            res=Math.max(res, var-i+values[i]);
            var= Math.max(var, values[i]+i);
            
        }
        return res;
    }
}
