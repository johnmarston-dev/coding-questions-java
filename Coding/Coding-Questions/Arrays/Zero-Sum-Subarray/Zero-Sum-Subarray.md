# Problem Description
You've given a list of integers **nums**. Write a function that returns a boolean representing whether there exists a zero-sum subarray of **nums**.

A zero-sum subarray is any subarray where all of the values add up to zero. A subarray is any contiguous section of the array. For the purposes of this problem, a subarray can be as small as one element and as long as the original array.

#### Sample Input
```java
nums = [-5, -5, 2, 3, -2]
```

#### Sample Output
```java
True // The subarray [-5, 2, 3] has a sum of 0
```

# Solution
If a subarray's elements sum up to zero(for example, **[0], [-3, 4, -1]**, etc.), it means that this subarray doesn't contribute to the total sum of all the elements in the main array.If we try to calculate the **totalSum** of all the elements in the main array, the value of the **totalSum** will remain the same before and after adding all elements in that subarray.

So we can utilize a **HashSet** to keep track of the values of **totalSum**, if the same value appears more than once, it means we have already met a zero-sum subarray.

```java
import java.util.*;

class Program {
	public boolean zeroSumSubarray(int[] nums){
		HashSet<Integer> sumSet = new HashSet<>();
		int totalSum = 0;
		
		for(int num : nums){
			totalSum += num;
			
			if(totalSum == 0 || sumSet.contains(totalSum)){
				return true;
			}
			
			sumSet.add(totalSum);
		}
		
		return false;
	}
}
```

# Complexity Analysis
**Time Complexity:** The time complexity for this solution is **O(n)**, where n is the length of the input array, since we only need to iterate through the input array once.

**Space Complexity:** The time complexity for this solution is **O(n)**, where n is the length of the input array.Because we're using a HashSet to store those sum values, and in the worst case(when the given array doesn't contain any zero-sum subarray), we need to store n sum values, resulting in an **O(n)** space complexity.