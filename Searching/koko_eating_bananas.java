/**
 * Problem: Koko Eating Bananas
 * Link: https://leetcode.com/problems/koko-eating-bananas/
 *
 * -------------------------------------------------------
 * APPROACH:
 * The minimum possible eating speed is 1 banana/hour, and the
 * maximum possible speed is the size of the largest pile.
 *
 * Use Binary Search on the answer (eating speed):
 * - For a given speed (mid), calculate the total hours required
 *   to finish all piles.
 * - Hours for each pile = ceil(pile / speed), computed as:
 *       (pile + speed - 1) / speed
 * - If the total hours are within the allowed limit (h),
 *   try a smaller eating speed.
 * - Otherwise, increase the eating speed.
 *
 * Continue until the minimum valid eating speed is found.
 *
 * PATTERN: Binary Search on Answer
 * TIME COMPLEXITY: O(n log m)
 *   - n = number of piles
 *   - m = maximum pile size
 * SPACE COMPLEXITY: O(1)
 * -------------------------------------------------------
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int pile : piles){
            high = Math.max(high,pile);
        }
 
        while(low<high){
            int mid = low+(high-low)/2;
            long hours = 0;
            for(int p : piles){
                hours +=(p + mid -1)/mid;

            }
            if(hours <= h){
         
                high = mid  ;
            }else{
                low = mid + 1;
            }
        }
        return low;
        
    }
}