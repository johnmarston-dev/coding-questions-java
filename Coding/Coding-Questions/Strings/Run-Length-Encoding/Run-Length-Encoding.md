# Problem Description
Write a function that takes in a non-empty string and returns its run-length encoding.

From Wikipedia, "run-length encoding is a from of lossless data compression in which runs of data are stored as a single data value and count, rather than as the original run." For this problem, a run of data is any sequence of consecutive, identical characters. So the run **"AAA"** would be run-length-encoded as **"3A"**. 

To make things more complicated, however, the input string can contain all sorts of special characters, including numbers. And since encoded data must be decodable, this means that we can't naively run-length-encode long runs. For example, the run **"AAAAAAAAAAAA"**(12 **A**s), can't naively be encoded as **"12A"**, since this string can be decoded as either **"AAAAAAAAAAAA"** or **"1AA"**. Thus, long runs(runs of 10 or more characters) should be encoded in a split fashion; the aforementioned run should be encoded as **"9A3A"**.

#### Sample Input
```java
string = "AAAAAAAAAAAAABBCCCCDD"
```

#### Sample Output
```java
"9A4A2B4C2D"
```

# Solution
For this problem, we can simply iterate through all the characters in the string and count the length for each run, then we calculate its encoding.

 However,as indicated by the problem description, for runs of 10 or more characters, we should encode them in a split fashion.So we need to introduce a helper method to process the encoding separately in order to keep the logic clear and the code clean.

```java
import java.util.*;

class Program {
	public String runLengthEncoding(String string){
		// Create a StringBuilder to store the results
		StringBuilder result = new StringBuilder();
		
		int currentRunLength = 0;
		char currentRunChar = string.charAt(0);
		
		for(int i = 0; i < string.length(); i++){
			// Identical character found, extend the currentRunLength
			if(string.charAt(i) == currentRunChar){
				currentRunLength++;
			}
			
			// Once encountered a new character, calculate the encoding for the previous run
			if(string.charAt(i) != currentRunChar){
				calculateRunEncoding(result, currentRunLength, currentRunChar);
				// Then update information for the new run
				currentRunChar = string.charAt(i);
				currentRunLength = 1;
			}
			
			// Once hit the end of the string, directly calculate the encoding for the current run
			if(i == string.length() - 1){
				calculateRunEncoding(result, currentRunLength, currentRunChar);
			}
		}
		
		// Return the results
		return result.toString();
	}
	
	// Helper method to help calculate the encoding for the given run 
	private void calculateRunEncoding(StringBuilder result, int currentRunLength, char currentRunChar){
		if(currentRunLength > 9){
			// For runs with 10 or more characters, do the encoding in a split fashion.
			int repetition = currentRunLength / 9;
			for(int j = 0; j < repetition; j++){
				result.append(String.valueOf(9));
				result.append(String.valueOf(currentRunChar));
			}
			result.append(String.valueOf(currentRunLength % 9));
			result.append(String.valueOf(currentRunChar));
		} else {
			result.append(String.valueOf(currentRunLength));
			result.append(String.valueOf(currentRunChar));
		}
	}
}
```

# Complexity Analysis
**Time Complexity:** The time complexity for this solution is **O(n)**, where n is the length of the input string.

This solution iterates over each character of the input string exactly once, contributing **O(n)** time complexity.As for the helper method that updates the StringBuilder, in the worst case where each character only appears once, it will do the append operation at most 2n times, hence this part also contributes **O(n)** to the overall time complexity.

**Space Complexity:** The space complexity for this solution is **O(n)**, where n is the length of the input string.We created a StringBuilder to hold the encoded characters, in the worst case where each character only appears once, there will be 2n characters in the encoded string.However, usually the length of the encoded string will be shorter than 2n, hence the space complexity can be considered **O(n)**.