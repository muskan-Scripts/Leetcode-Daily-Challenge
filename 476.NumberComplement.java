class Solution {
    public int findComplement(int num) {
       StringBuilder sb= new StringBuilder();
       while(num>0){
        int res= num%2;
        num=num/2;
        if(res==1)sb.append('0');
        else{sb.append('1');}


       }
       sb.reverse();
       if(sb.length()==0)return 1;
       int result=0;
       String curr= sb.toString();
       for(int i=0; i<curr.length(); i++){
        if(curr.charAt(i)=='1'){
            result=result+(int)(Math.pow(2, curr.length()-i-1));
        }
       }

       return result;
    }
}
