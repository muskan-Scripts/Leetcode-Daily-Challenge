

//User function template for JAVA
class Solution {
    public void shortest_distance(int[][] matrix) {
        int n = matrix.length;
        
        // Floyd-Warshall Algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Check if i->k and k->j are reachable
                    if (matrix[i][k] != -1 && matrix[k][j] != -1) {
                        // Calculate new distance
                        int newDistance = matrix[i][k] + matrix[k][j];
                        // Update matrix[i][j] if new distance is smaller or if it's initially -1
                        if (matrix[i][j] == -1) {
                            matrix[i][j] = newDistance;
                        } else {
                            matrix[i][j] = Math.min(matrix[i][j], newDistance);
                        }
                    }
                }
            }
        }
    }
}
