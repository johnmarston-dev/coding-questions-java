
# Problem Description
Given a non-empty string of lowercase letters and a non-negative integer representing a key, write a function that returns a new string obtained by shifting every letter in the input string by k positions in the alphabet, where k is the key.

Note that letters should "wrap" around the alphabet; in other words, the letter **z** shifted by one returns the letter **a**.

#### Sample Input
```java
string = "xyz"
key = 2
```

#### Sample Output
```java
"zab"
```

# Solution
As indicated by the problem description, letters "wrap" around the alphabet, so shifting by 26 times will bring you back to the original letter.To avoid unnecessary  large shifts, we need to normalize the key using the modulus operation.

Next, we just iterate through the characters in the string one by one.For each one of them, we add the key to it, then we use modulus 122 to wrap around if necessary.Finally, we convert it back to a character and append it to the result string.

```java
class Problem {
	public static String caesarCypherEncryptor(String str, int key){
		// Normalize the key to prevent unnecessary large shifts
		key = key % 26;
		
		// Create a StringBuilder to store the result
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++){
			// Get the new character after shifting with the key
			char shiftedChar = shiftCharacter(str.charAt(i), key);
			// Append it to the result
			result.append(shiftedChar);
		}
	}
	
	private static char shiftCharacter(char c, int key){
		// Calculate new character code after shifting
		int shiftedCharCode = c + key;
		
		if(shiftedCharCode > 'z'){
			shiftedCharCode = 'a' + shiftedCharCode % 122 - 1;
		}
		
		return (char)shiftedCharCode;
	}
}
```

# Complexity Analysis
**Time Complexity:** The time complexity for this solution is **O(n)**, where n is the length of the input string, since we only iterate over each character in the string exactly once.

**Space Complexity:** The space complexity for this solution is **O(n)**, where n is the length of the input string, since we're using a StringBuilder to store all shifted characters.