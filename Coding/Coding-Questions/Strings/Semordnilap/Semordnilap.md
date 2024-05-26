# Problem Description
Write a function that takes in a list of unique strings and returns a list of semordnilap pairs.

A semordnilap pair is defined as a set of different strings where the reverse of one word is the same as the forward version of the other.For example the words "diaper" and "repaid" are a semordnilap pair, as are the words "palindromes" and "semordnilap".

The order of the returned pairs and the order of the strings within each pair does not matter.

#### Sample Input
```java
words = ["diaper", "abc", "test", "cba", "repaid"]
```

#### Sample Output
```java
[["diaper", "repaid"], ["abc", "cba"]]
```

# Solution
For each word in the array, if its reversed word also exists in the array, and it's not the same as the original word, then they form a semordnilap pair.

To check if a reversed word exist in the array, we can definitely scan the entire array whenever we want, but it's not time efficient.A better option might be converting the input array to a set for quick lookup.

```java
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
```

# Complexity Analysis
**Time Complexity:** The time complexity for this solution is **O(n * m)**, where n is the length of the input array, and m is the length of the longest word in the array.We firstly convert the array to a set which takes O(n) time then we iterate over the array to check each word for its potential semordnilap pair.For each word, we generate its reversed word which takes O(m) time where m is the length of the word, and it's repeated n times for all words.Thus in the worst case, the time complexity is **O(n * m)**, where n is the length of the input array, and m is the length of the longest word in the array.

**Space Complexity:** The space complexity for this solution is **O(n * m)**, where n is the length of the input array, and m is the length of the longest word in the array.The HashSet we used earlier stores all the strings in the input array, and since Java stores strings as an array of characters, the length of each string should be taken into consideration when it comes to the space complexity analysis, especially in scenarios where string lengths vary significantly or are comparably large.

