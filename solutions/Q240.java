class Q240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // for matrix[i][j], top & left are smaller
        // right & bottom are larger
        // which is to devide the board diagonally 
        // start from bottom-left corner
        // if larger, go up, else go right
        int row = matrix.length-1;
        int col = 0;
        while (row>=0 && col<matrix[0].length){
            if (matrix[row][col] < target){
                col++;
            } else if (matrix[row][col] > target){
                row--;
            } else {
                return true;
            }
        }
        return false;
    }
}