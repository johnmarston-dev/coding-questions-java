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