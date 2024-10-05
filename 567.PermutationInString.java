class Solution {
     private boolean equate(int[] pf, int[] sf) {
        for (int i = 0; i < 26; i++) {
            if (pf[i] != sf[i])
                return false;
        }
        return true;
    }
    public boolean checkInclusion(String p, String s) {
         
        if (s.length() < p.length())
            return false;

        int[] pf = new int[26];
        int[] sf = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pf[p.charAt(i) - 'a']++;
            sf[s.charAt(i) - 'a']++;
        }

        if (equate(sf, pf))
            return true;

        int st = 0;
        int end = p.length();

        while (end < s.length()) {
            sf[s.charAt(st) - 'a']--;
            sf[s.charAt(end) - 'a']++;
            st++;
            end++;

            if (equate(sf, pf))
                return true;
        }

        return false;
    }
}


