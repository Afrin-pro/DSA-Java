/**
 * Problem: Richest Customer Wealth
 * LeetCode: #167 — Easy
 *
 * APPROACH:
 * Iterating through a 2D array to calculate row sums and find the maximum value.
 *
 * PATTERN: Array / Bruteforce Search
 *
 * TIME COMPLEXITY: O(m * n)
 * SPACE COMPLEXITY: O(1)
 */
class Solution {
    public int maximumWealth(int[][] accounts) {
        int wealth = 0;

        for (int i = 0; i < accounts.length; i++) {
             int sum = 0;

            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }

            wealth = Math.max(wealth, sum);
        }

        return wealth;

        
    }
}
