class Solution {
    public int minimumLength(String s) {

        int len=s.length();
        if (len <= 2) return len;

        int chararr[] = new int[26];

        for (int i=0; i < len; i++) {
            chararr[s.charAt(i) - 'a']++;
            if (chararr[s.charAt(i)-'a'] > 2) chararr[s.charAt(i)-'a']=chararr[s.charAt(i)-'a']-2;
        }

        int ans=0;
        for (int cnt : chararr) {
            ans=cnt+ans;
        }
        
        return ans;
    }
}
