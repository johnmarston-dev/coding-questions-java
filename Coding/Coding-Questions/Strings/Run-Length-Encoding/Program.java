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