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