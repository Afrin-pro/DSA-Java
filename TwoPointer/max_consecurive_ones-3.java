/**
 * Problem: Max Consecutive Ones III
 * LeetCode: #1004 — Medium
 *
 * APPROACH:
 * Use a sliding window to find the longest subarray containing
 * at most `k` zeros.
 *
 * Expand the window by moving `r` and count the number of zeros
 * inside the current window.
 *
 * If the number of zeros becomes greater than `k`, move `l`
 * forward while decreasing the zero count whenever a zero
 * leaves the window.
 *
 * Once the window contains at most `k` zeros, update `maxterm`
 * with the current window length.
 *
 * PATTERN: Sliding Window
 * TECHNIQUE: Two Pointers
 *
 * TIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(1)
 */
class Solution {
    public int longestOnes(int[] nums, int k) {
        int l =0;
        int r =0;
        int count =0;
        int maxterm =0;
        while(r < nums.length){
            if(nums[r] == 0){
                count++;
            }
            while(count > k){
                if(nums[l] == 0){
                    count--;
                }
                l++;
            }
            if(count <= k){
                maxterm = Math.max(maxterm,r-l+1);
                r++;
            }
        }
        return maxterm;
        
    }
}