/**
 * Problem: Majority Element
 * LeetCode: #169 — Easy
 *
 * APPROACH:
 * Use a HashMap to count the frequency of each element.
 * Then iterate through the array and find the element with the
 * highest frequency. Since the majority element appears more than
 * n / 2 times, the element with the highest frequency is the answer.
 *
 * PATTERN: Frequency Count using HashMap
 *
 * TIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(n)
 */
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int count =0;
        int ans =0;
        for(int i =0; i< nums.length;i++){
            if(map.get(nums[i]) > count){
                count = map.get(nums[i]);
                ans = nums[i];
            }
        }
        return ans;    
    }
}