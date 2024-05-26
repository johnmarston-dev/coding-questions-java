# Problem Description
Given an array of integers between **1** and **n**, inclusive, where **n** is the length of the array, write a function that returns the first integer that appears more than once (when the array is read from left to right).

In other words, out of all the integers that might occur more than once in the input array, your function should return the one whose first duplicate value has the minimum index.

if no integer appears more than once, your function should return **-1**.

Note that you're allowed to mutate the input array.

#### Sample Input #1
```java
array = [2, 1, 5, 2, 3, 3, 4]
```

#### Sample Output #1
```java
2 // 2 is the first integer that appears more than once.
// 3 also appears more than once, but the second 3 appears after the second 2.
```

#### Sample Input #2
```java
array = [2, 1, 5, 3, 3, 2, 4]
```

#### Sample Output #2
```java
3 // 3 is the first integer that appears more than once.
// 2 also appears more than once, but the second 2 appears after the second 3.
```

# Solution
We can absolutely use a brute-force solution to solve the problem, but it results in O(n^2) time complexity.We can also use a **Set** that has constant-time lookups to keep track of occurrences of each integer, which effectively reduces the time complexity to O(n) but still requires O(n) space complexity.

Note that the integers are between 1 and n, inclusive, where n is the length of the array. And the prompt also explicitly allows us to mutate the array.How could it be a coincidence?Absolutely not!It tells us we can take advantage of the array itself to mark each integer's occurrences.

To achieve this, we can map each integer to index in the array by subtracting 1 from it.Then we can mutate the value at the index that the integer maps to and make it negative(by multiplying it by -1).Normally, the integers in the array are all positive, if we encounter one at the index that the current integer maps to with negative value, that means we've already met the current integer before.

```java
import java.util.*;

class Program {
	public int firstDuplicateValue(int[] array){
		for(int value : array){
			// Calculate the index that the current element maps to
			int index = Math.abs(value) - 1;
			//
			if(array[index] < 0){
				return Math.abs(value);
			} else {
				array[index] *= -1;
			}
		}
	}
}
```

# Complexity Analysis
**Time Complexity:** The time complexity for this solution is O(n), where n is the length of the input array, since we only need to traverse the array once.

**Space Complexity:** The time complexity for this solution is O(1), since we're using the input array itself for storing the information about visited numbers and there are no other data structures being used that grow with the input size.

