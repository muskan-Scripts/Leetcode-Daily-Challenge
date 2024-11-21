class Solution {
    private void trav(int r, int c, char[][] arr) {
        // Traverse upwards
        int ru = r - 1;
        while (ru >= 0 && arr[ru][c] != 'w' && arr[ru][c] != 'g') { // Stop at walls or guards
            arr[ru][c] = 'v'; // Mark as visible
            ru--;
        }

        // Traverse downwards
        int rd = r + 1;
        while (rd < arr.length && arr[rd][c] != 'w' && arr[rd][c] != 'g') { // Stop at walls or guards
            arr[rd][c] = 'v'; // Mark as visible
            rd++;
        }

        // Traverse rightwards
        int cr = c + 1;
        while (cr < arr[0].length && arr[r][cr] != 'w' && arr[r][cr] != 'g') { // Stop at walls or guards
            arr[r][cr] = 'v'; // Mark as visible
            cr++;
        }

        // Traverse leftwards
        int cd = c - 1;
        while (cd >= 0 && arr[r][cd] != 'w' && arr[r][cd] != 'g') { // Stop at walls or guards
            arr[r][cd] = 'v'; // Mark as visible
            cd--;
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] arr = new char[m][n];

        // Fill the grid with 'z' (unguarded cells)
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], 'z');
        }

        // Mark guards as 'g'
        for (int[] guard : guards) {
            int r = guard[0];
            int c = guard[1];
            arr[r][c] = 'g';
        }

        // Mark walls as 'w'
        for (int[] wall : walls) {
            int r = wall[0];
            int c = wall[1];
            arr[r][c] = 'w';
        }

        // Traverse for each guard to mark visible cells
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 'g') {
                    trav(i, j, arr);
                }
            }
        }

        // Count unguarded cells
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 'z') { // Count unguarded cells
                    ans++;
                }
            }
        }

        return ans;
    }
}
