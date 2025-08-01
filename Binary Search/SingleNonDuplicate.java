class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;

        int l = 0 ; 
        int r = n - 1;

        while (l<=r){

            int mid =  l + (r-l)/2;
            
            int left = mid - l;
            int right = r - mid;


            if ((mid-1>=0) && nums[mid-1]==nums[mid]){
                left--;
                if (left%2==1)
                    r = mid -2;
                else
                    l = mid + 1;
            }
            else if ((mid + 1)< n && nums[mid+1]==nums[mid]){
                right--;
                if (right%2==1)
                    l = mid + 2;
                else
                    r = mid -1;
            }
            else
                return nums[mid];
            
        }

        return -1;
    }
}
