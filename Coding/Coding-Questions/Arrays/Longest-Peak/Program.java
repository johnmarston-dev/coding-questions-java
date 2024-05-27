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