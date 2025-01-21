class Solution {

    public int islandPerimeter(int[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        int ans = 0;
        int ro[] = {1,-1,0,0};
        int co[] = {0,0,1,-1};

        for (int i=0; i < grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                vis[i][j]=1;
                if (grid[i][j] == 1){
                    
                    for (int m=0; m < 4; m++) {
                    int r=i+ro[m];
                    int c=j+co[m];
                    if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 0){
                        ans++;
                    }
                    else if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
                        ans++;
                    }
                }
                }

            }
        }
        return ans;
    }
}
