public class Q74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // vertical locate
        int top = 0;
        int bottom = matrix.length-1;
        while (top < bottom-1){
            int mid = (top+bottom)/2;
            if (matrix[mid][0]>target){
                bottom = mid -1;
            } else if (matrix[mid][0]<target){
                top = mid;
            } else {
                return true;
            }
        }
        // corner case: only 2 rows
        if (matrix[bottom][0] < target){
            top = bottom;
        } else if (matrix[bottom][0] == target){
            return true;
        }
        // horizontal locate
        int left = 0;
        int right = matrix[0].length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if (matrix[top][mid]>target){
                right = mid-1;
            } else if (matrix[top][mid]<target){
                left = mid+1;
            } else {
                return true;
            }
        }
        return false;
    }
}
