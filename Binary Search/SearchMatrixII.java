public class SearchMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int r = 0;
        int c = n - 1;

        while(r<m && c>=0){

            int curr = matrix[r][c];

            if (curr==target)
                return true;
            
            if (target<curr)
                c--;
            else
                r++;

        }

        return false;
    }
}
}
