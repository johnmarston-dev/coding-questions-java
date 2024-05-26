# Problem Description
Write a function that, given a string, returns its longest palindromic substring.

A palindrome is defined as a string that's written the same forward and backward. Note that single-character strings are palindromes.

You can assume that there will only be one longest palindromic substring.

#### Sample Input
```java
string = "abaxyzzyxf"
```

#### Sample Output
```java
"xyzzyx"
```


# Solution
The brute-force approach may be iterating all possible substrings and try to find the one that is a palindrome string with the longest length.But it's not recommended due to its cubic scaling of time complexity(which is O(n^3)).Thus we need to find a more efficient one.

As indicated by the problem description, a palindrome is a string that's written the same forward and backward.That means, we can split a palindrome into two symmetrical parts from the middle character(when it has an odd length), or the middle gap between two central characters(when it has an even length).

So, we can treat each character as the middle character of a potential palindromic substring(when it has an odd length).Then we try to expand from the middle towards both sides, continuing to check if the characters on both sides match each other.Similarly, for even-length palindromic substrings, we consider each gap between consecutive characters as the middle and perform the same expansion procedure.

This approach is far more efficient and reduces the time complexity from **O(n^3)** to **O(n^2)**.


```java
import java.util.*;

class Program {
    public static String longestPalindromicSubstring(String str){
        String longestPalindrome = "";

        for(int i = 0; i < str.length(); i++){
            // Odd-length palindromes: treat each character as the center
            String oddPalindrome = expandSymmetricalSides(str, i, i);
            if(oddPalindrome.length() > longestPalindrome.length()){
                longestPalindrome = oddPalindrome;
            }

            // Even-length palindromes: treat the gap between consecutive characters as the center
            if(i + 1 < str.length()){
                String evenPalindrome = expandSymmetricalSides(str, i, i + 1);
                if(evenPalindrome.length() > longestPalindrome.length()){
                    longestPalindrome = evenPalindrome;
                }
            }
        }

        return longestPalindrome;
    }

    // Helper method to find out the possible longest palindrome
    private static String expandSymmetricalSides(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    // Main method
    public static void main(String[] args){
        String inputString = "abaxyzzyxf";
        String longestPalindrome = longestPalindromicSubstring(inputString);
        System.out.println(longestPalindrome);
    }
}

```

# Complexity Analysis
**Time Complexity:** The time complexity for this solution is **O(n^2)**, where n is the length of the input string.

During the expansion process, for each character, we expand on both sides to find the longest palindrome.In the worst case where the entire string is a palindrome and the current character is the center of the string, the expansion process will cover each character in the string, resulting in a **O(n)** time complexity.Since we perform this symmetrical expansion for each character, the overall time complexity is **O(n^2)**.

**Space Complexity:** The space complexity for this solution is **O(n)**, where n is the length of the input string.

When it comes to the space complexity, the main concern here is the `substring()` method.Each time we try to find the longest palindrome substring by calling the method `expandSymmetricalSides()`, a new String object will be created.But that object is transient, and will be discarded soon once there's another substring found with longer length.Only the one with the longest length will be persisted(in the `longestPalindrome` variable) and in the worst case, where the entire input string is a palindrome, we need to store the entire input string, thus the space complexity is **O(n)**.
