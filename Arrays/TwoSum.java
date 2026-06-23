/**
 * Problem: Two Sum
 * LeetCode: #1 — Easy
 * Link: https://leetcode.com/problems/two-sum/
 *
 * -------------------------------------------------------
 * APPROACH:
 * Use a brute-force approach by checking every possible pair
 * of elements in the array. If the sum of a pair equals the
 * target, return their indices immediately.
 *
 * PATTERN: Brute Force / Nested Loops
 *
 * TIME COMPLEXITY:  O(n²)
 * SPACE COMPLEXITY: O(1)
 * -------------------------------------------------------
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i =0; i<n-1;i++){
            for(int j=i+1; j<n;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }

            }
        }
        return new int[]{};
        
    }
}
