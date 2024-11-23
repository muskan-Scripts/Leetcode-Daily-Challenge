class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] rotatedBox = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; ++j) {
                if (j > 0 && box[i][j] == '.' && box[i][j - 1] == '#') {
                    box[i][j] = '#';
                    box[i][j - 1] = '.';
                    j = 0;
                }
            }
        }
  

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotatedBox[i][j] = box[m-j-1][i];
            }
        }
        
        return rotatedBox;
    }
    
}
