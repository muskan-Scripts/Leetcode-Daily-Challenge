class Solution {
    public int getLucky(String s, int t) {
        int sum=0;
        for(int i=0; i<s.length(); i++){
            int k= s.charAt(i)-'a'+1;
            while(k>0){
                sum=sum+k%10;
                k=k/10;
            }
        }

        for(int i=2; i<=t; i++){
            int k=sum;
            sum=0;
            while(k>0){
                sum=sum+k%10;
                k=k/10;
            }
        }
        return sum;
    }
}
