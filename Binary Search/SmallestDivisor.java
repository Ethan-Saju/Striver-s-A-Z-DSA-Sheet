public class SmallestDivisor {
    
    public int smallestDivisor(int[] nums, int threshold) {
        
        int l = 1;
        int r = Integer.MIN_VALUE;
        for(int num : nums)r = Math.max(r , num);
        
        int res = r;

        while (l<=r){

            int mid = l + (r-l) /2;
            System.out.println(mid);

            int sum = 0;

            for(int num : nums){
                sum += getQuotient(num , mid);
                if (sum>threshold)
                    break;
            }
                
            
            if (sum>threshold)
                l = mid + 1;
            else {
                res = mid;
                r = mid -1;
            }
        }

        return res;
    }

    
    public int getQuotient(int num , int divisor){
        
        int result = num / divisor;

        //Ceil
        if (num%divisor>0)
            result++;
        
        return result;

    }
}

