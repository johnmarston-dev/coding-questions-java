
# Problem Description
Write a function that takes in a non-empty list of non-empty strings and returns a list of characters that are common to all strings in the list, ignoring multiplicity.

Note that the strings are not guaranteed to only contain alphanumeric characters. The list you return can be in any order.

#### Sample Input
```java
strings = ["abc", "bcd", "cbaccd"]
```

#### Sample Output
```java
["b", "c"] // The characters could be ordered differently.
```

# Solution
The solution to this problem is quite straightforward, we just convert each string to a set to remove any duplicate characters, then we only retain common characters among those sets.

```java
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

```

# Complexity Analysis
**Time Complexity:** The time complexity for this solution is **O(n * m)**, where n is the number of strings, and m is the length of the longest string.For each string, we convert it into a set of unique characters, which takes approximately **O(m)** time for each string, since we're doing this for n strings, the overall time complexity would be **O(n * m)**.

**Space Complexity:** The space complexity for this solution is **O(c)**, where c is the number of unique characters across all strings.



---

# Further Insights
For `result[index++] = String.valueOf(ch);`, the **valueOf()** method actually expects a **char** primitive value, but here, only the **Character** object is provided.However, thanks to auto-unboxing in Java, this line of code could run without any issues.

# Auto-unboxing
Auto-unboxing is the automatic conversion that the Java compiler makes from wrapper classes to their corresponding primitive types.This feature is useful when you are retrieving elements from a collection and want to use them as primitives, or when you are passing an object wrapper to a method that expects a primitive.

# Auto-boxing
Auto-boxing is the automatic conversion that the Java compiler makes from the primitive types(like **int**, **char**, **double**, etc.) to their corresponding object wrapper classes(like **Integer**, **Character**, **Double**, etc.).This feature is extremely useful when you need to add primitives to collections like **ArrayList**, **HashMap**, **HashSet**, etc., which only store objects and not primitives.

# Example
```java
List<Double> list = new ArrayList<Double>();
list.add(3.14);
double pi = list.get(0);
```

Here, **3.14** is a primitive **double**. When it is added to the **list**, Java automatically converts it from **double** to **Double**.Without auto-boxing, the programmer would need to manually do the conversion via `list.add(Double.valueOf(3.14));`. 

Note that **pi** is declared as a primitive **double**.The **get()** method of **ArrayList** returns a **Double** object, but Java automatically converts this **Double** object back to a primitive **double**.Without auto-unboxing, the programmer would need to manually do the conversion via `double pi = list.get(0).doubleValue();`