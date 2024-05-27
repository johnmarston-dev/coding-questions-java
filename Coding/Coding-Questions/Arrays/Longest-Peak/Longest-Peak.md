# Problem Description
Write a function that takes in an array of integers and returns the length of the longest peak in the array.

A peak is defined as adjacent integers in the array that are **strictly** increasing until they reach a tip(the highest value in the peak), at which point they become **strictly** decreasing.At least three integers are required to form a peak.

For example, the integers **1, 4, 10, 2** form a peak, but the integers **4, 0, 10** don't and neither do the integers **1, 2, 2, 0**. Similarly, the integers **1, 2, 3** don't form a peak because there aren't any strictly decreasing integers after the **3**.

#### Sample Input
```java
array = [1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]
```

#### Sample Output
```java
6 // 0, 10, 6, 5, -1, -3
```

# Solution
As indicated by the problem description, each peak has a tip, and that tip is actually the integer that is strictly greater than its adjacent integers.So we can take advantage of this and find out all those tips in the array.

Once we find out a tip of a peak, we can expand outwards from both sides of the tip to calculate **currentPeakLength** until we hit the edges of the peak.Don't forget to keep track of the longest peak.

```java
import java.util.*;

class Program {
	public static int longestPeak(int[] array){
		// At least 3 integers are required to form a peak
		// For arrays with fewer than 3 integers, there's no peak at all
		if(array.length < 3){
			return 0;
		}

		// Keep track of the longest peak
		int maxPeakLength = 0;

		for(int i = 1; i < array.length - 1; i++){
			int currentPeakLength = 0;
			// Determine whether the current integer is the tip of a potential peak
			boolean isPeak = array[i] > array[i+1] && array[i] > array[i-1];

			if(isPeak){
				// We've found a peak, calculate its length from both sides
				int left = i;
				int right = i;
				while(left > 0 && array[left] > array[left-1]){
					currentPeakLength++;
					left--;
				}
				
				while(right < array.length - 1 && array[right] > array[right+1]){
					currentPeakLength++;
					right++;
				}
				
				// Then we need to update the longest peak
				// Since we didn't count the current integer, we need to add 1 to currentPeakLength
				if(currentPeakLength + 1 > maxPeakLength){
					maxPeakLength = currentPeakLength + 1;
				}
				
				// Once finished the right traverse during the calculation,
				// the right pointer is actually on the right edge of the peak.
				// To find the next tip of a potential peak,
				// we need to update the index and start from the right pointer
				i = right;
			}
			
		}

		// Return the results
		return maxPeakLength;
	}
}
```

# Complexity Analysis
**Time Complexity:** The time complexity for this solution is O(n), where n is the length of the input array.

The main loop iterates through the array once, hence contributing O(n) to the time complexity.For each potential peak found, the algorithm expands the peak to the left and right until it's no longer ascending.In this part, each element is visited at most once,therefore, it also contributes O(n) to the time complexity.

**Space Complexity:** The space complexity for this solution is O(1) because it only uses a constant amount of extra space regardless of the input size.There are no data structures being used that grows with the input size, only a few integer variables to keep track of indices and lengths.