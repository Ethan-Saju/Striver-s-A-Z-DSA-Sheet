public class FindMin {
    public int findMin(int[] nums) {
            
        int l = 0;
        int r = nums.length - 1;

        int res = Integer.MAX_VALUE;

        while(l<=r){

            int mid = l + (r-l)/2;

            //if left side is sorted;

            if (nums[l]<=nums[mid]){
                res = Math.min(res,nums[l]);
                l = mid + 1;
            } else {
                res = Math.min(res,nums[mid]);
                r = mid - 1;
            }
        }

        return res;
    
    }
}
