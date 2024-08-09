class Solution {
    private boolean ismagicsquare(int[][] grid, int r, int c){
        int[] arr=new int[9];
        int exp=-1;
        for(int i=r; i<r+3; i++){
                int s=0;
            for(int j=c; j<c+3; j++){
                if(grid[i][j]>9 || grid[i][j]==0|| arr[grid[i][j]-1]!=0)return false;
                arr[grid[i][j]-1]++;
                s=s+grid[i][j];
            }
            if(exp==-1)exp=s;
            if(s!=exp)return false;
        }

        int fd= grid[r][c]+grid[r+1][c+1]+grid[r+2][c+2];
        if(fd!=exp)return false;
        int ad= grid[r][c+2]+grid[r+1][c+1]+grid[r+2][c];
        if(ad!=exp)return false;
        for(int j=c; j<c+3; j++){
            int sum=0;
            for(int i=r; i<r+3; i++){
                sum+=grid[i][j];
            }
            if(sum!=exp)return false;
        }
        return true;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int ans=0;
        for(int i=0; i<grid.length-2; i++){
            for(int j=0; j<grid[i].length-2; j++){
                if(ismagicsquare(grid, i, j))ans++;
            }
        }

        return ans;
    }
}
