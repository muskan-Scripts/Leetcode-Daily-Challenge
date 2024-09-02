class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        // Calculate the total sum of chalk needed in one complete round
        long totalSum = 0;
        for (int c : chalk) {
            totalSum += c;
        }
        
        // Reduce k by the total sum (find the remainder)
        k %= totalSum;
        
        // Find the student who will replace the chalk
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        
        return -1;  // This line should never be reached with valid input
    }
}
