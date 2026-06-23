# Problem Notes

Use this file to log problems you find tricky, patterns you notice, or mistakes to revisit.

---

## Mistakes to Revisit

| Problem | Mistake | Fix |
|---------|---------|-----|
| LC001 Two Sum | Used nested loop O(n²) | Use HashMap for O(n) |

---

## Patterns Learned

### HashMap Frequency Counter
```java
map.put(n, map.getOrDefault(n, 0) + 1);
```
Used in: Two Sum, Valid Anagram, Group Anagrams

### Two Pointer
```java
int l = 0, r = arr.length - 1;
while (l < r) { ... }
```
Used in: Valid Palindrome, 3Sum, Container With Most Water

### Sliding Window
```java
int l = 0, maxLen = 0;
for (int r = 0; r < s.length(); r++) {
    // expand window
    while (/* invalid */) l++;
    maxLen = Math.max(maxLen, r - l + 1);
}
```
Used in: Longest Substring Without Repeating, Min Window Substring

---

## Topics to Revisit
- [ ] Floyd's cycle detection
- [ ] Tree diameter via DFS
- [ ] DP recurrence for knapsack
