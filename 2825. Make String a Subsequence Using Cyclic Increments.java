class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int p1=0;
        int p2=0;
        while(p1<str1.length() && p2<str2.length()){
            if(str1.charAt(p1)==str2.charAt(p2))p2++;
            else if(((str1.charAt(p1)-'a')+1)%26==((str2.charAt(p2)-'a')%26))p2++;
            p1++;
        }
        return p2==str2.length();
    }
}
