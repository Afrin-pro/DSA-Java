/**
 * Problem: Split Array Largest Sum
 * LeetCode: #410 — Hard
 *
 * APPROACH:
 * 1. We need to split the array into k subarrays such that
 *    the maximum subarray sum is minimized.
 *
 * 2. This is solved using Binary Search on Answer:
 *    - Lower bound (start) = max element in array
 *      (because no subarray can have sum less than max element)
 *    - Upper bound (end) = sum of all elements
 *      (one subarray containing everything)
 *
 * 3. For a given mid (assumed max allowed subarray sum),
 *    we greedily split the array:
 *    - Keep adding elements to current subarray
 *    - If sum exceeds mid, start a new subarray
 *
 * 4. Count how many subarrays are needed.
 *    - If subarrays > k → mid is too small (increase start)
 *    - Else → mid might be valid (try smaller value)
 *
 * PATTERN:
 * Binary Search on Answer + Greedy Partitioning
 *
 * TIME COMPLEXITY:
 * - O(n log(sum of array))
 *   where:
 *   n = number of elements
 *   log(sum) = binary search range
 *
 * SPACE COMPLEXITY:
 * - O(1)
 */
class Solution {
    public int splitArray(int[] nums, int k) {
        int start =0;
        int end = 0;
        for(int i=0; i< nums.length;i++){
            start = Math.max(start,nums[i]);
            end += nums[i];
        }
        //binary search
        while(start < end){
            int mid = start+(end-start)/2;
            //calculate how many pieces can you divide with this max sum
            int sum =0;
            int subArray =1;
            for(int num : nums){
                if(sum+num > mid){
                    /* you cannot add the num in this subarray,you need new one. if you add the num in new subarray, the sum is now sum = num */
                    sum = num;
                    subArray++;
                }else{
                    sum += num;
                }
            }
            if(subArray > k){
                start = mid +1;
            }else{
                end = mid;
            }
        }
        return start;
        
    }
}