class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] arr = new int[n + 1]; // Difference array with an extra space
        
        // Update difference array using shift ranges
        for (int[] curr : shifts) {
            int st = curr[0];
            int en = curr[1];
            int d = curr[2] == 0 ? -1 : 1; // Convert 0 to -1 for left shift
            arr[st] += d;
            if (en + 1 < arr.length) {
                arr[en + 1] -= d; // Update en+1 to stop the effect of shift
            }
        }
        
        // Compute the prefix sum to get cumulative shifts
        int cumulativeShift = 0;
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            cumulativeShift += arr[i];
            int netShift = (cumulativeShift % 26 + 26) % 26; // Normalize shifts to be within 0-25
            char cch = s.charAt(i);
            char newChar = (char) ((cch - 'a' + netShift) % 26 + 'a'); // Apply shift
            result[i] = newChar;
        }
        
        return new String(result);
    }
}
