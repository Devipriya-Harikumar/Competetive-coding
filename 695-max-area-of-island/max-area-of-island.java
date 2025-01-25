class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        List<String> visited = new ArrayList<>();
        int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int maxArea = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited.contains(i + "," + j)) {
                    maxArea = Math.max(maxArea,
                            bfs(grid, row, col, i, j, visited, directions));
                }
            }
        }
        return maxArea;
    }

    private int bfs(int[][] grid, int row, int col, int r, int c, List<String> visited, int[][] directions) {
        int count = 1;
        visited.add(r + "," + c);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { r, c });

        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int[] point : directions) {
                int nr = p[0] + point[0];
                int nc = p[1] + point[1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 1
                        && !visited.contains(nr + "," + nc)) {
                    count++;
                    q.add(new int[] { nr, nc });
                    visited.add(nr + "," + nc);
                }

            }
        }

        return count;
    }
}