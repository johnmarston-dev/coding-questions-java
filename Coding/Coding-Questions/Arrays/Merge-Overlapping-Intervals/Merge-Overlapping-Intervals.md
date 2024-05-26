# Problem Description
Write a function that takes in a non-empty array of arbitrary intervals, merges any overlapping intervals, and returns the new intervals in no particular order.

Each interval **interval** is an array of two integers, with **interval[0]** as the start of the interval and **interval[1]** as the end of the interval.

Note that back-to-back intervals aren't considered to be overlapping.For example, **[1, 5]** and **[6, 7]** aren't overlapping; however, **[1, 6]** and **[6, 7]** are indeed overlapping.

Also note that the start of any particular interval will always be less than or equal to the end of that interval.

#### Sample Input
```java
intervals = [[1, 2], [3, 5], [4, 7], [6, 8], [9, 10]]
```

#### Sample Output
```java
[[1, 2], [3, 8], [9, 10]]
// Merge the intervals [3, 5], [4, 7], and [6, 8].
// The intervals could be ordered differently.
```

# Solution
For two intervals to be overlapping, the first interval's ending value must be greater than or equal to the second one's starting value.And in order to do it efficiently without any verbose operations, we need to sort the input intervals array.

```java
import java.util.*;

class Program {
  public int[][] mergeOverlappingIntervals(int[][] intervals) {
    // Write your code here.
    // Sort the array by starting value.
    // But before that, we need to make a copy of the original array
    // to avoid directly mutating it.
    int[][] intervalsCopy = intervals.clone();
    for(int i = 0; i < intervals.length; i++){
      intervalsCopy[i] = intervals[i].clone();
    }

    Arrays.sort(intervalsCopy, (a, b) -> Integer.compare(a[0], b[0]));

    List<int[]> merged = new ArrayList<>();

    for(int[] currentInterval : intervalsCopy){
      // If merged is empty, add the first interval to it.
      if(merged.isEmpty()){
        merged.add(new int[] {currentInterval[0], currentInterval[1]});
        continue;
      }

      int[] lastMerged = merged.get(merged.size() - 1);
      int lastMergedEnd = lastMerged[1];
      int currentIntervalStart = currentInterval[0];
      int currentIntervalEnd = currentInterval[1];

      if(lastMergedEnd < currentIntervalStart){
        merged.add(new int[] {currentInterval[0], currentInterval[1]});
      } else {
        // Merge overlapping interval and update lastMergedEnd
        lastMergedEnd = Math.max(lastMergedEnd, currentIntervalEnd);
        merged.get(merged.size() - 1)[1] = lastMergedEnd;
      }

    }
    
    return merged.toArray(new int[merged.size()][]);
  }
}


```

# Complexity Analysis
**Time Complexity:** This solution starts by sorting the intervals using **Arrays.sort()** based on their starting points, contributing **O(nlogn)** time complexity.Then it iterate through the sorted intervals once to merge overlapping intervals.This iteration takes **O(n)** time complexity, where n is the number of intervals.

Even though the iteration process has a linear time complexity **O(n)**, the overall time complexity of the algorithm is dominated by the sorting step.So the time complexity for this solution is **O(nlogn)**.

**Space Complexity:** This solution makes a copy of the input intervals array to avoid mutating the original input.This requires **O(n)** space.Then it uses an **ArrayList** to store merged intervals.In the worst case, if no intervals overlap, the space required for this list would also be **O(n)**.Finally, the **ArrayList** is converted into an array, which also occupies **O(n)** space.

Thus the overall space complexity for this solution is **O(n)**.


---
# Further Insights
---
# Shallow Copy - also see [[arrays]]
In this solution, we start by using the **clone()** method to make a copy of the input two-dimensional array, but it is a shallow copy because only references to the inner arrays are cloned, those inner arrays themselves are not.This means that changes to the inner arrays in the cloned array will reflect in the original input array.

Remember the initial goal of making a copy of the original array is to avoid mutating it, even though we can solve the problem with just shallow cloning, it still introduces potential risks if we accidentally mutate those inner arrays, thus violating that initial principle.

So that's why we need the following for-loop to manually finish the cloning process.Also note that for arrays of primitive types(like **int[]**, **double[]**, etc.), the method **clone()** still does a good job at creating a new array with the same values, making the new array completely independent of the original one.
```java
for(int i = 0; i < intervals.length; i++){
  intervalsCopy[i] = intervals[i].clone();
}
```



# Lambda Expression - also see [[Lambda Expression]]
Lambda expressions in Java provide a concise way to express instances of single-method interfaces(also known as **functional interfaces**,such as `java.util.Comparator<T>`) by using syntax that resembles a function declaration in other languages. It doesn't have a name and can be used as a value and it's a powerful feature of Java that allows for more expressive and readable code.

Lambda expressions provide a way to write compact and expressive code, making it easier to understand at a glance and enabling you to customize the sorting behavior on the fly. Without lambdas, you would need to create a separate class or an anonymous inner class that implements the `Comparator<T>` interface, which is way more verbose.

In the above solution, a lambda expression `(a, b) -> Integer.compare(a[0], b[0])` is provided for the method **Arrays.sort()**,then Java infers that this lambda expression is an implementation of the **compare()** method in the `Comparator<T>` interface. 

Later on, the lambda expression is transformed by the Java compiler into an instance of a class that implements `Comparator<T>` interface, generating a synthetic method that contains the code from the lambda's body. 

Finally, the synthetic method created by the compiler serves as the implementation of the **compare()** method required by the `Comparator<T>` interface. This method is executed by the specific sorting algorithm within the **sort()** method whenever the **compare()** method of this dynamically created `Comparator<T>` instance is invoked. 

# The Merging Process
```java
merged.add(currentInterval);
merged.add(new int[] {currentInterval[0], currentInterval[1]});
```

When adding intervals to the `merged` list, creating a new interval array rather than directly adding the `currentInterval` from the input array `intervalsCopy` is a matter of ensuring that the operations performed during the merge do not inadvertently modify the original input data, separating input data from the output processing.It maintains data integrity, ensuring that no side effects occur if the `intervalsCopy` array is used later in the code.This practice aligns well with functional programming principles, where data is treated as immutable.

In general, creating new intervals rather than directly using the intervals from the sorted list ensures that changes to the merged intervals do not propagate back to the input data, maintaining the functional integrity of the merging process. This approach reduces bugs and simplifies debugging and testing by avoiding unintended data dependencies and mutations.




