class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();

        int[] maxfreq = new int[26];
        for (String word : words2) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                maxfreq[i] = Math.max(maxfreq[i], freq[i]);
            }
        }

        for (String word : words1) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] < maxfreq[i]) {
                    isUniversal = false;
                    break;
                }
            }

            if (isUniversal) {
                ans.add(word);
            }
        }

        return ans;
    }
}
