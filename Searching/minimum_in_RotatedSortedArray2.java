/**
 * Problem: Find Minimum in Rotated Sorted Array II
 * LeetCode: #154 — Hard
 *
 * APPROACH:
 * 1. Find the pivot (index of the largest element) using a modified binary search.
 * 2. Handle duplicate values by shrinking the search space from both ends
 *    when start, mid, and end contain the same value.
 * 3. Once the pivot is found, the minimum element is located at pivot + 1.
 * 4. If no pivot is found, the array is not rotated, so the first element
 *    is the minimum.
 *
 * PATTERN:
 * Binary Search + Pivot Finding (Handling Duplicates)
 *
 * TIME COMPLEXITY:
 * - Best/Average Case: O(log n)
 * - Worst Case (many duplicates): O(n)
 *
 * SPACE COMPLEXITY:
 * - O(1)
 */
class Solution {
    public int findMin(int[] nums) {
        int pivot = findDuplicatePivot(nums);
        return nums[pivot+1];
        
    }
    int findDuplicatePivot(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if( mid>start && arr[mid] < arr[mid -1]){
                return mid-1;
            }
            if(mid<end && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(arr[mid]==arr[start]&& arr[mid]==arr[end]){
                if(start<end &&arr[start]>arr[start+1]){
                    return start;
                }
                start++;
                if(end>start &&arr[end]<arr[end-1]){
                    return end-1;
                }
                end--;
            }
            else if(arr[start]<arr[mid] || (arr[start] == arr[mid]&&arr[mid]>arr[end])){
                start = mid+1;
            }else{
                end = mid -1;
            }
        }
        return -1;
    }

}