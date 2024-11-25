class Solution {
    public int slidingPuzzle(int[][] board) {
        // The target configuration as a string
        String targetConfiguration = "123450";

        // Initialize BFS queue with the starting configuration and step count as 0
        Queue<PuzzleState> queue = new LinkedList<>();
        queue.add(new PuzzleState(boardToString(board), 0));

        // Set to track visited configurations to avoid revisiting
        Set<String> visited = new HashSet<>();
        visited.add(queue.peek().state);

        // Perform BFS to find the shortest path to the target configuration
        while (!queue.isEmpty()) {
            PuzzleState currentStep = queue.poll();
            String currentState = currentStep.state;
            int stepCount = currentStep.steps;

            // If the current configuration matches the target, return the step count
            if (Objects.equals(currentState, targetConfiguration)) {
                return stepCount;
            }

            // Explore all valid neighboring configurations
            for (String neighbor : getValidNeighbors(currentState)) {
                if (!visited.contains(neighbor)) {
                    queue.offer(new PuzzleState(neighbor, stepCount + 1));
                    visited.add(neighbor);
                }
            }
        }
        
        return -1;
    }

    /**
     * Generates all valid neighboring configurations of the current board state.
     *
     * @param currentState The current board state as a string.
     * @return A list of valid neighboring board states as strings.
     */
    private List<String> getValidNeighbors(String currentState) {
        List<String> neighbors = new ArrayList<>();
        int[][] board = stringToBoard(currentState);
        int[][] directions = CommonUtils.getVerticalHorizontalDirections();

        // Find the position of the empty space (represented by 0)
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] != 0) continue;

                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (CommonUtils.validGrid(board.length, board[0].length, newRow, newCol)) {
                        // Swap the empty space with the adjacent tile
                        int temp = board[newRow][newCol];
                        board[newRow][newCol] = 0;
                        board[row][col] = temp;

                        // Add the new configuration as a valid neighbor
                        neighbors.add(boardToString(board));

                        // Revert the swap to restore the original configuration
                        board[newRow][newCol] = temp;
                        board[row][col] = 0;
                    }
                }
            }
        }

        return neighbors;
    }

    /**
     * Converts a 2D board array to a string representation.
     *
     * @param board The 2D array representation of the board.
     * @return The string representation of the board.
     */
    public String boardToString(int[][] board) {
        StringBuilder builder = new StringBuilder();
        for (int[] row : board) {
            for (int cell : row) {
                builder.append(cell);
            }
        }
        return builder.toString();
    }

    /**
     * Converts a string representation of the board to a 2D array.
     *
     * @param state The string representation of the board.
     * @return The 2D array representation of the board.
     */
    public int[][] stringToBoard(String state) {
        int[][] board = new int[2][3];
        for (int i = 0; i < state.length(); i++) {
            board[i / 3][i % 3] = state.charAt(i) - '0';
        }
        return board;
    }
}

class CommonUtils {
    public static boolean validGrid(int n, int m, int nextRow, int nextCol) {
        return (nextRow >= 0 && n > nextRow && nextCol >= 0 && m > nextCol);
    }

    public static int[][] getVerticalHorizontalDirections() {
        return new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    }

}

class PuzzleState {
    String state; // Current board configuration as a string
    int steps;    // Number of steps taken to reach this configuration

    public PuzzleState(String state, int steps) {
        this.state = state;
        this.steps = steps;
    }
}
