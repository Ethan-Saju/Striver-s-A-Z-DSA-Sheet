public class FirstAndLastPos {
    
    public int[] searchRange(int[] nums, int target) {
        return new int[]{binarySearch(nums,target,true),binarySearch(nums,target,false)};
    }

    public int binarySearch(int[] nums, int target , boolean first){
        int l = 0 ;
        int r = nums.length - 1;

        int res = -1;

        while (l<=r){

            int mid = l + (r-l)/2;

            if (nums[mid]<target)
                l = mid + 1;
            else if (nums[mid]>target)
                r = mid - 1;
            else {
                res = mid;
                if (first)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }

        return res;
    }

}

