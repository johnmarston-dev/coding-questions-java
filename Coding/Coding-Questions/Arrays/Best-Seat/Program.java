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