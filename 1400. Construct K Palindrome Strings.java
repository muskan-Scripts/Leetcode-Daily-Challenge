class Solution {
    public boolean canConstruct(String s, int k) {

        if (s.length() < k) return false;
        int cntodd=0;
        int[] charscnt= new int[26];

        for (char curr : s.toCharArray()) {

            charscnt[curr - 'a']++;
            if (charscnt[curr - 'a'] % 2 == 0) {
                cntodd--;
            }
            else {
                cntodd++;
            }
        }

        if (cntodd > k) return false;

        return true;
        
    }
}
