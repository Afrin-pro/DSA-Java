/**
 * Problem: Search a 2D Matrix II
 * LeetCode: #240 — Medium
 *
 * APPROACH:
 * Start from the top-right corner of the matrix.
 * - If the current element equals the target, return true.
 * - If the current element is smaller than the target,
 *   move down to the next row since all elements to the
 *   left are also smaller.
 * - If the current element is larger than the target,
 *   move left since all elements below in the same column
 *   are also larger.
 *
 * This eliminates one row or one column in every step.
 *
 * PATTERN: Binary Search on Sorted Matrix (Staircase Search)
 *
 * TIME COMPLEXITY: O(m + n)
 * SPACE COMPLEXITY: O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;
        while(row < matrix.length && col >=0){
            if(matrix[row][col] == target){
                return true;
            }
            if(matrix[row][col] < target){
                row++;
            }else{
                col--;
            }
        }
        return false;
        
    }
}