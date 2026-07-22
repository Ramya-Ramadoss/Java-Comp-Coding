/*Longest Substring Without Repeating Characters
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        // Store the most recent index of each character
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            // If character is already in the window, move left pointer
            if (charIndexMap.containsKey(currentChar)) {
                // Move left to one position after the last occurrence
                // or keep it at its current position if it's already ahead
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
            }
            
            // Update the character's latest index
            charIndexMap.put(currentChar, right);
            
            // Calculate current window length and update max
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
