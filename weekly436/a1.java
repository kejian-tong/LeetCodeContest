class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for (int row = n - 1; row >= 0; row--) {
            sortDiagonal(grid, row, 0, false);
        }

        for (int col = 1; col < n; col++) {
            sortDiagonal(grid, 0, col, true);
        }

        return grid;
    }

    private void sortDiagonal(int[][] grid, int row, int col, boolean ascending) {
        PriorityQueue<Integer> heap;
        if (ascending) {
            heap = new PriorityQueue<>(); 
        } else {
            heap = new PriorityQueue<>((a, b) -> b - a); 
        }

        int i = row, j = col, n = grid.length;

        while (i < n && j < n) {
            heap.add(grid[i][j]);
            i++;
            j++;
        }

        i = row;
        j = col;
        while (i < n && j < n) {
            grid[i][j] = heap.poll();
            i++;
            j++;
        }
    }
}
// Time: O(n^2 * log(n))
// Space: O(n)