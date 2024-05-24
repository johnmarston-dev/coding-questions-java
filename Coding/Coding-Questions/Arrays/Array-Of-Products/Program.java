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