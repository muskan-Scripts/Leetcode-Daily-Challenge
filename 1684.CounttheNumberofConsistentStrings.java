class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] isall=new boolean[26];
        for(char c: allowed.toCharArray()){
            isall[c-'a']=true;
        }
        int cnt=0;
        for(String word: words){
            boolean isc=true;
            for(char c: word.toCharArray()){
                if(isall[c-'a']==false){
                    isc=false;
                    break;
                }
            }
            if(isc)cnt++;
        }
        return cnt;
    }
}
