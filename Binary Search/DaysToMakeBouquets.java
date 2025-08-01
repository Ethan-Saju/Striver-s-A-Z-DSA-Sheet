public class DaysToMakeBouquets {
    
    public int minDays(int[] bloomDay, int m, int k) {

        if ((long)m * k > bloomDay.length)
            return -1;
        
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;

        for(int day : bloomDay){
            l = Math.min(l,day);
            r = Math.max(r,day);
        }

        int res = r;

        while(l<=r){

            int mid = l + (r-l) /2;

            int bouquets = getBouquets(bloomDay ,k , mid , m);
            
            if(bouquets<m)
                l = mid + 1;
            else {
                res = mid;
                r = mid -1;
            }

        }

        return res;
    }

    public int getBouquets(int[] bloomDay, int k , int day , int m){

        int n  = bloomDay.length;

        int bouquets = 0;

        int count = 0;

        for(int r = 0 ; r<n; r++){
            if (bloomDay[r]<=day){
                count++;
                if (count==k){
                    count = 0;
                    bouquets++;
                }   
            } 
            else count = 0;

            if (bouquets==m)
                break;
        }

        return bouquets;
    }
}

