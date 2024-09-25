class Node {
    int freq;
    boolean eow;
    Node[] narr;

    public Node() {
        this.freq = 0;
        this.eow = false;
        this.narr = new Node[26];
    }
}

class Trie {
    Node st;

    public Trie() {
        this.st = new Node();
    }

    public void insert(String s) {
        Node stt = this.st;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((stt.narr[ch - 'a']) == null) {
                stt.narr[ch - 'a'] = new Node();
            }
            stt.narr[ch - 'a'].freq++;
            stt = stt.narr[ch - 'a'];
            if (i == s.length() - 1) {
                stt.eow = true;
            }
        }
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie tt = new Trie();
        for (String word : words) {
            tt.insert(word);
        }
        int sol[] = new int[words.length];
        int ptr = 0;
        for (String word : words) {
            int ws = 0;
            for (int i = 1; i <= word.length(); i++) {
                String pf = word.substring(0, i);

                Node stt = tt.st;

                for (int j = 0; j < pf.length(); j++) {
                    char ch = pf.charAt(j);
                    stt=stt.narr[ch-'a'];
                    if(j==pf.length()-1){
                        ws+= stt.freq;
                    }
                }
            }
            sol[ptr]=ws;

            ptr++;
        }

        return sol;

    }
}
