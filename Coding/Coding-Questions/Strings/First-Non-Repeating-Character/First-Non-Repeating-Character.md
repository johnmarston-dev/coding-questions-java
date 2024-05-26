# Problem Description
Write a function that takes in a string of lowercase English-alphabet letters and returns the index of the string's first non-repeating character.

The first non-repeating character is the first character in a string that occurs only once.

If the input string doesn't have any non-repeating characters, your function should return **-1**.

#### Sample Input
```java
string = "abcdcaf"
```

#### Sample Output
```java
1 // The first non-repeating character is "b" at the index 1.
```

# Solution
To tackle this problem, we can simply adopt a brute-force approach with nested traversals of the input string.For each character, we scan the entire string to check if it only occurs once.If it does, we return its index.

This approach works, but it's not optimal.A better solution might be utilizing a hash table to track each character's frequency.This approach significantly reduces the time complexity from **O(n^2)** to **O(n)**.

Also, as indicated by the problem description, the input string only has lowercase English-alphabet letters.Since the hash table only stores frequencies for unique characters in the string, there will be at most 26 key-value pairs in the table.Hence we can achieve a space complexity of **O(1)** with this approach.

```java
import java.util.*;

class Program{
	public int firstNonRepeatingCharacter(String string){
		// Store each character's frequency in the HashMap
		HashMap<Character, Integer> characterCounts = new HashMap<Character, Integer>();
		for(char c : string.toCharArray()){
			characterCounts.put(c, characterCounts.getOrDefault(c, 0) + 1);
		}
		
		// Iterate over the string, find the one with only one occurrence
		// and return its index
		for(int i = 0; i < string.length(); i++){
			char currentCharacter = string.charAt(i);
			int frequency = characterCounts.get(currentCharacter);
			if(frequency == 1){
				return i;
			}
		}
		
		return -1;
	}
}
```

# Complexity Analysis
**Time Complexity:** The time complexity for this solution is **O(n)**, where n is the length of the input string.

**Space Complexity:** The space complexity for this solution is **O(1)**, because the input string only contains lowercase English-alphabet letters, and the hash table will have at most 26 key-value pairs.That's a constant number which won't grow with the input size.