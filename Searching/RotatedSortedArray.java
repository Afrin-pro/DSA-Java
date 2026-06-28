/**
 * Problem: Search in Rotated Sorted Array
 * LeetCode: #33 — Medium
 *
 * APPROACH:
 * 1. Find the pivot (the index of the largest element) using binary search.
 * 2. If no pivot exists, the array is not rotated, so perform a normal binary search.
 * 3. If the target is equal to the pivot element, return the pivot index.
 * 4. Otherwise, determine which sorted half may contain the target:
 *    - If target >= first element, search the left half.
 *    - Otherwise, search the right half.
 *
 * PATTERN: Binary Search + Pivot Finding
 *
 * TIME COMPLEXITY:
 * - Finding Pivot: O(log n)
 * - Binary Search: O(log n)
 * - Overall: O(log n)
 *
 * SPACE COMPLEXITY: O(1)
 */
class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if(pivot == -1){
            return binarySearch(nums,target,0,nums.length-1);
        }
        if(target == nums[pivot]){
            return pivot;
        }
        if(target >= nums[0]){
            return binarySearch(nums,target,0,pivot-1);
        }

        return binarySearch(nums,target,pivot+1,nums.length-1);


    }
    int binarySearch(int[] arr,int target,int start,int end){
        while(start<= end){
            int mid = start + (end - start)/2; 
            if(target < arr[mid]){
                end = mid -1;
            }
            else if(target>arr[mid]){
                start = mid +1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
    int findPivot(int[] arr){
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
            if(arr[mid]>=arr[start]){
                start=mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
}