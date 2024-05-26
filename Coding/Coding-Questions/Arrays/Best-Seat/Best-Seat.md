# Problem Description
You walk into a theatre you're about to see a show in.The usher within the theatre walks you to your row and mentions you're allowed to sit anywhere within the given row. Naturally you'd like to sit in the seat that gives you the most space. You also would prefer this space to be evenly distributed on either side of you(e.g. if there are three empty seats in a row, you would prefer to sit in the middle of those three seats).

Given the theatre row represented as an integer array, return the seat index of where you should sit. Ones represent occupied seats and zeroes represent empty seats.

You may assume that someone is always sitting in the first and last seat of the row. Whenever there are two equally good seats, you should sit in the seat with the lower index. If there is no seat to sit in, return -1. The given array will always have a length of at least one and contain only ones and zeroes.

#### Sample Input
```java
seats = [1, 0, 1, 0, 0, 0, 1]
```

#### Sample Output
```java
4
```

# Solution
To solve this problem, we need to find the longest consecutive subarrays of zeroes and return its middle index.

```java
import java.util.*;

class Program {
	public int bestSeat(int[] seats){
		int maxSpace = 0;
		int currentSpace = 0;
		int endingIndex = 0;
		int bestSeat = -1;
		
		for(int i = 0; i < seats.length; i++){
			if(seats[i] == 0){
				currentSpace++;
				continue;
			}
			
			if(currentSpace > maxSpace){
				maxSpace = currentSpace;
				endingIndex = i - 1;
				bestSeat = endingIndex - maxSpace / 2;
			}
			
			currentSpace = 0;
		}
		
		return bestSeat;
	}
}
```

# Complexity Analysis
**Time Complexity:** The time complexity for this solution is **O(n)**, where n is the length of the input array, since we only need to iterate through the input array once.

**Space Complexity:** The space complexity for this solution is **O(1)**, since it only uses a constant amount of extra space regardless of the input size.