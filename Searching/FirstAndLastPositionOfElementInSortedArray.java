/**
 * Problem: Find First and Last Position of Element in Sorted Array
 * LeetCode: #34 — Medium
 *
 * APPROACH:
 * Using modified binary search twice to find the leftmost and rightmost occurrences of a target in a sorted array.
 *
 * PATTERN: Binary Search
 *
 * TIME COMPLEXITY: O(log n)
 * SPACE COMPLEXITY: O(1)
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans ={-1,-1};
        ans[0]= Search(nums,target,true);
        if(ans[0] != -1)
        ans[1]= Search(nums,target,false);
        return ans;
    }
    int Search(int[] arr, int target ,boolean findStartIndex){
        int ans = -1;
        int start = 0;
        int end = arr.length -1;
        while(start<= end){
            int mid = start + (end - start)/2; 
            if(target < arr[mid]){
                end = mid -1;
            }
            else if(target > arr[mid]){
                start = mid +1;
            }
            else{
                ans = mid;
                if(findStartIndex){
                    end = mid -1;
                }
                else{
                    start = mid +1;
                }
            }
        }
        return ans;

    }
}
