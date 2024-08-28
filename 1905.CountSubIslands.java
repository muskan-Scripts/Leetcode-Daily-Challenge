class Solution {
    int sol = 0;
    boolean flag = true;

    private void cntsol(int i, int j, int[][] vis, int[][] grid, int[][] grid1) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        if (grid[i][j] == 0 || vis[i][j] == 1)
            return;
        vis[i][j] = 1;
        if (grid1[i][j] != grid[i][j])
            this.flag = false;
        cntsol(i + 1, j, vis, grid, grid1);
        cntsol(i - 1, j, vis, grid, grid1);
        cntsol(i, j - 1, vis, grid, grid1);
        cntsol(i, j + 1, vis, grid, grid1);
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int[][] vis = new int[grid1.length][grid1[0].length];
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                this.flag = true;
                if (vis[i][j] == 0 && grid2[i][j] == 1) {
                    cntsol(i, j, vis, grid2, grid1);
                    if (this.flag == true) {
                        this.sol++;
                    }
                }

            }
        }
        return sol;
    }
}
