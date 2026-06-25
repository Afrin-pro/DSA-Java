/**
 * Problem: Find Smallest Letter Greater Than Target
 * LeetCode: #744 — Easy
 *
 * APPROACH:
 * Use binary search to find the first character strictly greater than
 * the target. If the target is greater than or equal to the last
 * character in the array, wrap around and return the first character.
 *
 * PATTERN: Binary Search
 *
 * TIME COMPLEXITY: O(log n)
 * SPACE COMPLEXITY: O(1)
 */
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if(target>=letters[letters.length-1]){
            return letters[0];
        }
        int start = 0;
        int end = letters.length-1;
        while(start<= end){
            int mid = start + (end - start)/2; 
            if(target < letters[mid]){
                end = mid -1;
            }
            else {
                start = mid +1;
            }
        }
         return letters[start];
    }
}
