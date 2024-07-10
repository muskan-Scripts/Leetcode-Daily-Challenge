class Solution {
    public int minOperations(String[] logs) {
        int cnt=0;
        for(String curr: logs){
            if(curr.equals("./"))continue;
            else if(curr.equals("../")){
                cnt--;
                cnt=Math.max(0,cnt);
            }
            else{
                cnt++;
            }
        }
        return cnt;
    }
}
