class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fivc=0;
        int tenc=0;
        int twec=0;

        for(int curr: bills){
            if(curr==5){fivc++;}
            else if(curr==10){
                if(fivc==0)return false;
                else{
                    tenc++;
                    fivc--;
                }
            }
            else if(curr==20){
                twec++;
                if(fivc>0 && tenc>0){
                    fivc--;
                    tenc--;
                }
                else if(fivc>=3){
                    fivc=fivc-3;
                }
                else{
                    return false;
                }
            }
        }

        return true;
    }
}
