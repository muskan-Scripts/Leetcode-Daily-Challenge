class Solution {
    public boolean judgeSquareSum(int c) {
        long st=0;
        long end= (long)Math.sqrt(c);
        while(st<=end){
            if((st*st)+(end*end)==c){
                return true;
            }
            else if((st*st)+(end*end)<c){
                st++;
            }
            else{
                end--;
            }
        }
        return false;
    }
}