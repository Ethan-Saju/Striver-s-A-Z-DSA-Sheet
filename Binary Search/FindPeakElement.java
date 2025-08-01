public class FindPeakElement {
    public int findPeakElement(int[] nums) {

        int n = nums.length;

        int l = 0 ;
        int r = n- 1;


        while(l<=r){

            int mid = l +(r-l)/ 2;

            if ((mid-1)>=0 && nums[mid-1]>nums[mid])
                r = mid - 1;
            else if  ((mid+1)<n && nums[mid+1]>nums[mid])
                l = mid + 1;
            else 
                return mid;
        }
        
        return -1;
    }
}

