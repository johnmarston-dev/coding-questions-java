# Problem Description
Write a function that takes in a non-empty string and that returns a boolean representing whether the string is a palindrome.

A palindrome is defined as a string that's written the same forward and backward. Note that single-character strings are palindromes.

#### Sample Input
```java
string = "abcdcba"
```

#### Sample Output
```java
true // it's written the same forward and backward
```

# Solution
To solve this problem, we can simply adopt the recursive solution to compare characters one by one from both sides of the string, if any mismatch is found, the string is not a palindrome, otherwise it's indeed a palindrome.

```java
class Program {
	public static boolean isPalindrome(String str){
		return isPalindrome(str, 0);
	}
	
	public static boolean isPalindrome(String str, int left){
		// Get the index of the right end
		int right = str.length() - 1 - left;
		
		// If any mismatch is found, the string is not a palindrome
		if(str.charAt(left) != str.charAt(right)){
			return false;
		}
		
		// If both left and right have met or crossed,that means all checks have passed
		// The string is a palindrome
		if(left >= right){
			return true;
		} else {
			// Otherwise, continue to check
			return isPalindrome(str, ++left);
		}
	}
}
```

# Complexity Analysis
**Time Complexity:** The time complexity for this solution is **O(n)**, as the method recursively calls itself about **n/2** times, comparing two characters per call.

**Space Complexity:** The space complexity for this solution is **O(n)**, due to the stack space required for the recursive calls, which can grow up to **n/2** in depth.

In Java, each time a method is invoked, a new stack frame is pushed onto the call stack.In the worst case, the recursive method will be called **n/2** times before reaching the base case, where left index meets or crosses the right index.For each stack frame, there's no significant additional memory allocation required except for the input string itself and indices, the overall space complexity directly relates to the depth of the recursive calls.

---

While the recursive solution is elegant and straightforward, the space complexity can be a drawback for very long strings due to potential stack overflow issues.A more practical and efficient one might be the iterative approach, which uses two pointers and achieves a reduced space complexity of **O(1)**, since it wouldn't rely on the call stack.

```java
class Program{
	public static boolean isPalindrome(String str){
		int left = 0;
		int right = str.length() - 1;
		//
		while(left <= right){
			// Once a mismatch is found, the string is not a palindrome
			if(str.charAt(left) != str.charAt(right)){
				return false;
			}
			//
			left++;
			right--;
		}
		// If there's no mismatches, the string is indeed a palindrome
		return true;
	}
}
```

# Complexity Analysis
**Time Complexity:** The time complexity for this solution is **O(n)**, where n is the length of the input string, since the solution only iterates each character in the string at most once.

**Space Complexity:** The space complexity for this solution is **O(1)**, since it doesn't rely on the call stack like the recursive solution, and it only uses a constant amount of extra space regardless of the input size.
