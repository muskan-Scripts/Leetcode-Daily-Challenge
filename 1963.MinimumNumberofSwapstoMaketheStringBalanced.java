class Solution {
    public int minSwaps(String s) {
        int swapCount=0;
        int imbalance=0;
        for(char br: s.toCharArray()){
            if(br==']'){
                if(imbalance==0){
                    swapCount++;
                    imbalance++;
                }
                else{
                    imbalance--;
                }
            }
            else{
                imbalance++;
            }
        }

        return swapCount;
    }
}
