/**
 * Problem: Find Position of an Element in a Sorted Array of Infinite Numbers
 * Link: https://www.geeksforgeeks.org/dsa/find-position-element-sorted-array-infinite-numbers/
 *
 * -------------------------------------------------------
 * APPROACH:
 * First, find the range where the target may exist by exponentially
 * increasing the window size (start, end). Once the target is within
 * the range, apply binary search to find its exact position.
 *
 * PATTERN: Exponential Search + Binary Search
 * TIME COMPLEXITY: O(log n)
 * SPACE COMPLEXITY: O(1)
 * -------------------------------------------------------
 */

class Solution {

    static int findPos(int[] arr, int target) {
        int start = 0;
        int end = 1;
        while (arr[end] < target) {
            int newStart = end + 1;
            // double the box value
            // end = previous end + sizeOfBox*2
            end = end + (end - start + 1) * 2;
            start = newStart;
        }

        //  Binary search within range
        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        return -1;
    }
}