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