package LeetCodeContest.weekly438;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Step 1: Collect elements from each row respecting the limits
        for (int i = 0; i < grid.length; i++) {
            PriorityQueue<Integer> rowHeap = new PriorityQueue<>(Collections.reverseOrder());
            
            for (int num : grid[i]) {
                rowHeap.add(num);
            }
            
            int count = 0;
            while (!rowHeap.isEmpty() && count < limits[i]) {
                maxHeap.add(rowHeap.poll());
                count++;
            }
        }

        // Step 2: Extract the top k elements from the global max heap
        long sum = 0;
        while (!maxHeap.isEmpty() && k > 0) {
            sum += maxHeap.poll();
            k--;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] grid1 = {{1, 2}, {3, 4}};
        int[] limits1 = {1, 2};
        int k1 = 2;
        System.out.println(solution.maxSum(grid1, limits1, k1)); // Expected: 7

        int[][] grid2 = {{5, 3, 7}, {8, 2, 6}};
        int[] limits2 = {2, 2};
        int k2 = 3;
        System.out.println(solution.maxSum(grid2, limits2, k2)); // Expected: 21
    }
}
