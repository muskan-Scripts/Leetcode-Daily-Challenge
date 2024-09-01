class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if((m*n)!=original.length){
        int[][] ans= new int[0][0];
        return ans;
       }
        int[][] ans= new int[m][n];
        int ptr=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n ; j++){
                ans[i][j]=original[ptr++];
            }
        }
        return ans;
    }
}
