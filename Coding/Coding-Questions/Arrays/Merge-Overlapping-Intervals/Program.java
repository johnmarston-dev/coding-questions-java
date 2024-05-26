import java.util.*;

class Program {
  public int[][] mergeOverlappingIntervals(int[][] intervals) {
    // Write your code here.
    // Sort the array by starting value.
    // But before that, we need to make a copy of the original array
    // to avoid directly mutating it.
    int[][] intervalsCopy = intervals.clone();
    for(int i = 0; i < intervals.length; i++){
      intervalsCopy[i] = intervals[i].clone();
    }

    Arrays.sort(intervalsCopy, (a, b) -> Integer.compare(a[0], b[0]));

    List<int[]> merged = new ArrayList<>();

    for(int[] currentInterval : intervalsCopy){
      // If merged is empty, add the first interval to it.
      if(merged.isEmpty()){
        merged.add(new int[] {currentInterval[0], currentInterval[1]});
        continue;
      }

      int[] lastMerged = merged.get(merged.size() - 1);
      int lastMergedEnd = lastMerged[1];
      int currentIntervalStart = currentInterval[0];
      int currentIntervalEnd = currentInterval[1];

      if(lastMergedEnd < currentIntervalStart){
        merged.add(new int[] {currentInterval[0], currentInterval[1]});
      } else {
        // Merge overlapping interval and update lastMergedEnd
        lastMergedEnd = Math.max(lastMergedEnd, currentIntervalEnd);
        merged.get(merged.size() - 1)[1] = lastMergedEnd;
      }

    }
    
    return merged.toArray(new int[merged.size()][]);
  }
}

