import java.util.*;

class Program {
	public boolean generateDocument(String characters, String document){
		// If the document is empty,return true
		// since no characters are needed to generate the document
		if(document.length() == 0){
			return true;
		}
		
		// Count and store the frequency of each character in the characters string
		HashMap<Character, Integer> characterFrequency = new HashMap<Character, Integer>();
		for(char c : characters.toCharArray()){
			characterFrequency.put(c, characterFrequency.getOrDefault(c, 0) + 1);
		}
		
		// Check if the characters string has enough characters to generate the document
		for(char c : document.toCharArray()){
			// Insufficient of character c to generate the document
			if(!characterFrequency.containsKey(c) || characterFrequency.get(c) <= 0){
				return false;
			}
			// Update frequency for the character that we've already seen
			characterFrequency.put(c, characterFrequency.get(c) - 1);
		}
		
		return true;
	}
}