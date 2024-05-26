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

		return result.toString();
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