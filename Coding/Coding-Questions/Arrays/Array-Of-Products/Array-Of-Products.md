# Problem Description
Write a function that takes in a non-empty array of integers and returns an array of the same length, where each element in the output array is equal to the product of every other number in the input array.

In other words, the value at **output[i]** is equal to the product of every number in the input array other than **input[i]**.

Note that you're expected to solve this problem without using division.

#### Sample Input
```java
array = [5, 1, 4, 2]
```

#### Sample Output
```java
[8, 40, 10, 20]
// 8 is euqal to 1 x 4 x 2
// 40 is euqal to 5 x 4 x 2
// 10 is equal to 5 x 1 x 2
// 20 is equal to 5 x 1 x 4
```

# Solution
As indicated by the problem description, each element  **output[i]** in the output array is the product of every number from both sides(left and right) of the **input[i]** from the input array.

So instead of directly calculating the current element's product, which introduces multiple loops, we can prepare its **currentPrefixProduct** and **currentSuffixProduct** in advance.So that the current element's product would be **currentPrefixProduct * currentSuffixProduct**.

To achieve this, we need to initialize two arrays, **prefixProducts** and **suffixProducts**.For each element **array[i]**, we store the product of all elements to the left of it in **prefixProducts[i]**, and then store the product of all elements to the right of it in **suffixProducts[i]**.

```java
import java.util.*;

class Program {
	public int[] arrayOfProducts(int[] array){
		// Initialize the products array to store the results
		int n = array.length;
		int[] products = new int[n];
		
		// Calculate each element's currentPrefixProduct
		int currentPrefixProduct = 1;
		int[] prefixProducts = new int[n];
		for(int i = 0; i < n; i++){
			prefixProducts[i] = currentPrefixProduct;
			currentPrefixProduct *= array[i];
		}
		
		// Calculate each element's currentSuffixProduct
		int currentSuffixProduct = 1;
		int[] suffixProducts = new int[n];
		for(int i = n - 1; i >= 0; i--){
			suffixProducts[i] = currentSuffixProduct;
			currentSuffixProduct *= array[i];
		}
		
		// Calculate each element's product
		for(int i = 0; i < n; i++){
			products[i] = prefixProducts[i] * suffixProducts[i];
		}
		
		// Return the results
		return products;
	}
}
```

# Complexity Analysis
**Time Complexity:** The time complexity for this solution is O(n), where n is the length of the input array, since it traverses the array three times, with each time linearly proportional to the length of the input array.

**Space Complexity:** The space complexity of this solution is O(n), where n is the length of the input array, since we created additional arrays to store prefix and suffix products.
