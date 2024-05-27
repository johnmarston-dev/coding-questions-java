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