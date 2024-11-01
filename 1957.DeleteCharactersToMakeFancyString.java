class Solution {
    
    public String makeFancyString(String s) {
        int cnt=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char curr=s.charAt(i);
            if(i>0 && curr==s.charAt(i-1)){
                cnt++;
            }
            else{
                cnt=1;
            }
            if(cnt==3){
                cnt--;
            }
            else{
                sb.append(curr);
            }
        }
        return sb.toString();

    }
}
