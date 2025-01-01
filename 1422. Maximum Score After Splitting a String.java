class Solution {
    public int maxScore(String s) {
        int totalones=0;
        int ans=0;
        int arr[]=new int[s.length()];
        int arrptr=0;
        int zeroes=0;
        for(char k: s.toCharArray()){
            if(k=='0'){
                zeroes++;
            }
            
            else{
                totalones++;
            }
            arr[arrptr++]=zeroes;
        }

        for(int i=0; i<arr.length-1; i++){
            int z=arr[i];
          
            int o= totalones-((i+1)-z);
            
            ans=Math.max(z+o, ans);
           
        }
        
        return ans;
    }
}
