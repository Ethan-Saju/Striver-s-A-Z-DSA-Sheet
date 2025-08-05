public class ShipWithinDays {
   
    public int shipWithinDays(int[] weights, int days) {
        
        int l = 0;
        int r = 0;

        for(int weight: weights){
            l = Math.max(l,weight);
            r += weight;
        }

        int res = r;

        while (l<=r){

            int mid = l + (r-l) /2;
            //System.out.println(l+" "+r+" "+mid);
            int currentDays = getDays(weights ,mid);
            //System.out.println(currentDays);

            if (currentDays>days) //capacity too low
                l = mid + 1;
            else {
                res = mid;
                r = mid - 1;
            }

            
        }

        return res;
    }

    public int getDays(int[] weights,int capacity){


        int days = 0;

        int currWeight = 0;

        for(int weight : weights){
            if (currWeight + weight > capacity){
                days++;
                currWeight = weight;
            } else currWeight+=weight;
        }

        //Ship last container
        days++;

        return days;
    }
}

