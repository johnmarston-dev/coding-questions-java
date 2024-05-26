import java.util.*;

class Program {
   public static ArrayList<ArrayList<String>> semordnilap(String[] words){
        ArrayList<ArrayList<String>> semordnilapPairs = new ArrayList<ArrayList<String>>();

        // Conver the array to a set for quick lookup
        HashSet<String> wordsSet = new HashSet<String>();
        for(String word : words){
            wordsSet.add(word);
        }

        // Check each word for potential semordnilap pairs
        for(String word : words){
            String reversedWord = new StringBuilder(word).reverse().toString();

            if(!reversedWord.equals(word) && wordsSet.contains(reversedWord)){
                ArrayList<String> matchedPair = new ArrayList<String>();
                matchedPair.add(reversedWord);
                matchedPair.add(word);
                semordnilapPairs.add(matchedPair);
                // Remove matched pairs to avoid duplicate records in the result
                wordsSet.remove(reversedWord);
                wordsSet.remove(word);
            }
        }

        return semordnilapPairs;
   }

   public static void main(String[] args){
        String[] words = {"diaper", "abc", "test", "cba", "repaid"};
        ArrayList<ArrayList<String>> result = semordnilap(words);
        for(ArrayList<String> pair : result){
            System.out.println(pair);
        }
   }
}