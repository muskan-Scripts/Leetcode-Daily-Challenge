class Solution {
    public int findTheWinner(int n, int k) {
        int cnt = 0;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int curr = 0;

        while (cnt < (n - 1)) {
            while (arr[curr] == -1) {
                curr = (curr + 1) % n;
            }
            for (int i = 1; i < k; i++) {
                curr = (curr + 1) % n;
                while (arr[curr] == -1) {
                    curr = (curr + 1) % n;
                }
                
            }
            arr[curr] = -1;
           curr = (curr + 1) % n;
            cnt++;

        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != -1)
                return i + 1;
        }
        return -1;
    }
}
