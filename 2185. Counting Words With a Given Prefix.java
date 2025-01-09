class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans=0;
        for(String curr: words){
            if(curr.indexOf(pref)==0)ans++;
        }
        return ans;
    }
}
