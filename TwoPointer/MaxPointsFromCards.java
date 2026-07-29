/**
 * Problem: Maximum Points You Can Obtain from Cards
 * LeetCode: #1423 — Medium
 *
 * APPROACH:
 * Start by taking the first `k` cards from the left.
 * Then slide the selection by removing one card from the left
 * and adding one card from the right, updating the maximum score
 * after each shift.
 *
 * PATTERN: Sliding Window
 * TECHNIQUE: Two Pointers
 *
 * TIME COMPLEXITY: O(k)
 * SPACE COMPLEXITY: O(1)
 */
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lSum =0;
        int rSum =0;
        int maxPoints =0;
        for(int i =0;i<k;i++){
            lSum += cardPoints[i];
            maxPoints = lSum;
        }
        
        int rIndex = cardPoints.length -1;
        for(int i =k-1; i>=0;i--){
            lSum -= cardPoints[i];
            rSum += cardPoints[rIndex];
            rIndex = rIndex-1;
            maxPoints = Math.max(maxPoints,lSum+rSum);
        }
        return maxPoints;
    }
}