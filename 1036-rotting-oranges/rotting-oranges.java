class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int time = 0;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int[][] spread = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
    
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i <size ; i++) {
                int[] p = queue.poll();
                for (int[] pos : spread) {
                    int adjRow = p[0] + pos[0];
                    int adjCol = p[1] + pos[1];
                    
                    if (adjRow >= 0 && adjRow < row && adjCol >= 0 && adjCol < col &&
                            grid[adjRow][adjCol] == 1) {
                        grid[adjRow][adjCol] = 2;
                        queue.add(new int[] { adjRow, adjCol });
                        fresh--;
                    }
                }
            }
            time++;
        }
        if (fresh == 0)
            return time;
        else
            return -1;
    }
}