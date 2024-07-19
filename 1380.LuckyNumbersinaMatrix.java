class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] rmin=new int[matrix.length];
        for(int i=0; i<rmin.length; i++){
            rmin[i]=Integer.MAX_VALUE;
        }
        int[] cmax=new int[matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                int curr= matrix[i][j];
                cmax[j]=Math.max(cmax[j], curr);
                rmin[i]=Math.min(rmin[i], curr);
            }
        }
        List<Integer> ans= new ArrayList();
         for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                int curr= matrix[i][j];
                if(curr==rmin[i] && curr==cmax[j])ans.add(curr);
            }
        }
        return ans;
    }
}
