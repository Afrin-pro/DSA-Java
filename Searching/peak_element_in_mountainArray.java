/**
 * Problem: Peak Index in a Mountain Array
 * LeetCode: #852 — Medium
 *
 * APPROACH:
 * Use binary search to locate the peak element.
 * - If arr[mid] > arr[mid + 1], we are on the descending part
 *   of the mountain, so the peak is at mid or to its left.
 * - Otherwise, we are on the ascending part, so the peak lies
 *   to the right of mid.
 * Continue until start == end, which is the peak index.
 *
 * PATTERN: Binary Search on Answer
 *
 * TIME COMPLEXITY: O(log n)
 * SPACE COMPLEXITY: O(1)
 */
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start =0;
        int end = arr.length-1;
        while(start<end){
            int mid = start +(end-start)/2;
            if(arr[mid] > arr[mid+1]){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
        
    }
}