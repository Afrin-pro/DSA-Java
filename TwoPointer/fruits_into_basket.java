/**
 * Problem: Fruit Into Baskets
 * LeetCode: #904 — Medium
 *
 * APPROACH:
 * Use a sliding window to find the longest contiguous subarray
 * containing at most 2 distinct fruit types.
 *
 * Expand the window by moving `r` and store the frequency of each
 * fruit type in a HashMap.
 *
 * If the window contains more than 2 distinct fruit types,
 * move `l` forward while decreasing the frequency of the fruit
 * being removed. Remove it from the map when its count becomes 0.
 *
 * After maintaining a valid window, update `maxLength` with
 * the current window size.
 *
 * PATTERN: Sliding Window
 * TECHNIQUE: Two Pointers + HashMap
 *
 * TIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(1)
 *                 // At most 3 fruit types are stored temporarily
 */
class Solution {
    public int totalFruit(int[] fruits) {
        int l =0;
        int r= 0;
        int maxLength = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(r < fruits.length){
            map.put(fruits[r], map.getOrDefault(fruits[r],0)+1);
            while(map.size() > 2){
               map.put(fruits[l],map.get(fruits[l])-1);
               if(map.get(fruits[l]) == 0){
                  map.remove(fruits[l]);
                }
                l++;
            }
            maxLength = Math.max(maxLength,r-l+1);
            r++;
        }
        return maxLength;
        
        
    }
}