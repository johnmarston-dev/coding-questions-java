# Problem Description
Write a function that takes in an $n \times m$ tow-dimensional array(that can be square-shaped when $n == m$) and returns a one-dimensional array of all the array's elements in spiral order.

Spiral order starts at the top left corner of the two-dimensional array, goes to the right, and proceeds in a spiral pattern all the way until every element has been visited.

#### Sample Input
```java
array = [
[1,2,3,4],
[12,13,14,5],
[11,16,15,6],
[10,9,8,7]
]
```

#### Sample Output
```java
[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
```

# Solution
To traverse the two-dimensional array in a spiral pattern, we need to set up 4 boundaries to limit values of indexes, and shrink them one by one as we go through the process.

Note that in a spiral traverse algorithm, the directions are typically arranged in the order of right, down, left and up.If one of these directions cannot be traversed(due to reaching the edge of the matrix, for example), then the traverse stops and the remaining directions do not need to be traversed.

So that's why we need to check that if we hit the edge of the matrix after each traverse, if so, we can directly stop here, we don't need to proceed anymore.

```java
import java.util.*;

class Program {
	public static List<Integer> spiralTraverse(int[][] array){
		// 1.Get the dimensions of the array
		int rows = array.length;
		int columns = array[0].length;

		// 2.Set up initial 4 boundaries to limit the values of indexes
		// As we go through the spiral traverse, we'll shrink those boundaries one by one
		int top = 0;
		int bottom = rows - 1;
		int left = 0;
		int right = columns - 1;

		// 3.Initialize an ArrayList to store the results
		List<Integer> results = new ArrayList<>();

		// 4.Start the spiral traverse
		while(left <= right && top <= bottom){
			// Firstly, we go right
			for(int i = left; i <= right;i++){
				results.add(array[top][i]);
			}
			// Once we finished a right traverse, we need to shrink the top boundary
			top++;
			// If we hit the edge of the matrix, we stop here
			if(left > right || top > bottom){
				break;
			}
			
			
			// Then, we go down
			for(int i = top; i <= bottom; i++){
				results.add(array[i][right]);
			}
			// Once we finished a downward traverse, we need to shrink the right boundary
			right--;
			// If we hit the edge of the matrix, we stop here
			if(left > right || top > bottom){
				break;
			}
			
			
			// Next, we go left
			for(int i = right; i >= left; i--){
				results.add(array[bottom][i]);
			}
			// Once we finished a left traverse, we need to shrink the bottom boundary
			bottom--;
			// If we hit the edge of the matrix, we stop here
			if(left > right || top > bottom){
				break;
			}
			
			
			// Finally, we go up
			for(int i = bottom; i >= top; i--){
				results.add(array[i][left]);
			}
			// Once we finished a upward traverse, we need to shrink the left boundary
			left++;
			// We don't need to check if we hit the edge or not, the while loop itself can check
		}

		// 5.Finally, return the results
		return results;
	}
}
```

# Complexity Analysis
**Time Complexity:** The time complexity for this solution is $O(n)$, where $n$ is the total number of elements in the matrix, since we only need to traverse each element of the matrix once in a spiral pattern.

**Space Complexity:** The space complexity for this solution is $O(n)$, where $n$ is the total number of elements in the matrix.This is because we store the elements of the matrix in the `results` list, which grows linearly with the number of elements in the matrix.