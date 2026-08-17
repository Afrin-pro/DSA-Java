/**
 * Problem: Valid Anagram
 * LeetCode: #242 — Easy
 *
 * APPROACH:
 * Check if both strings have the same length. If not, they cannot be anagrams.
 *
 * Use a HashMap to count the frequency of each character in string s.
 * Then iterate through string t and decrease the frequency of each character.
 *
 * If a character is not present in the HashMap, return false.
 * When a character's frequency becomes 0, remove it from the HashMap.
 *
 * At the end, if the HashMap is empty, both strings are anagrams.
 *
 * PATTERN: Frequency Count using HashMap
 *
 * TIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(k)
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);//adding into hashmap
        }
        for(char c:t.toCharArray()){
            if(!map.containsKey(c)){
                return false;
            }
            map.put(c,map.get(c)-1);//decreasing frequency
            if(map.get(c) == 0){
                map.remove(c);//frequency is 0 , remove it
            }
        }
        return map.isEmpty();
    }

}