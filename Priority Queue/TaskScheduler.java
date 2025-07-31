import java.util.*;

class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {

        int counter[] = new int[26];
        for(char c : tasks) counter[c-'A']++;
        
        int nextAvailability[] = new int[26];
            
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{

            if (nextAvailability[a]==nextAvailability[b]) // If both are available at the same cycle
                return Integer.compare(counter[b],counter[a]); //Do one with more instances left
            
            return Integer.compare(nextAvailability[a],nextAvailability[b]); // Else do one which we can do at earlier cycle

        });

        for(int i = 0  ; i < 26 ; i++){
            if (counter[i]>0) pq.add(i);
        }
        
        int currentCycle = 0;

        while (!pq.isEmpty()){
            
            int curr = pq.poll();

            currentCycle = Math.max(currentCycle , nextAvailability[curr]);

            counter[curr]--;

            if (counter[curr]>0){
                nextAvailability[curr]+=(n+1);
                pq.add(curr);
            }

            currentCycle++;
        }
        
        return currentCycle;
    }
}
