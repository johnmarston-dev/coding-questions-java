import java.util.*;

class Program {
  public String[] commonCharacters(String[] strings) {
    // Initialize the set with characters from the first string
    Set<Character> commonChars = new HashSet<Character>();
    for(char c : strings[0].toCharArray()){
      commonChars.add(c);
    }

    // Process each remaining string and only retain common characters
    for(int i = 1; i < strings.length; i++){
      Set<Character> currentChars = new HashSet<Character>();
      for(char c : strings[i].toCharArray()){
        currentChars.add(c);
      }

      commonChars.retainAll(currentChars);
    }

    // Convert the set to the desired string array
    String[] result = new String[commonChars.size()];
    int index = 0;
    for(Character ch : commonChars){
      result[index++] = String.valueOf(ch);
    }

    return result;
  }
}
