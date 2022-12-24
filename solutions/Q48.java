class Q48 {
    public void rotate(int[][] matrix) {
        for (int i=0; i<matrix.length/2; i++){
            _rotate(matrix, i);
        }
    }

    private void _rotate(int[][] matrix, int circle){
        int n = matrix.length;
        int to_change = matrix.length - circle*2 -1;
        for (int i=0; i<to_change; i++){
            int temp = matrix[circle][circle+i];
            matrix[circle][circle+i] = matrix[n-circle-i-1][circle];
            matrix[n-circle-i-1][circle] = matrix[n-circle-1][n-circle-i-1];
            matrix[n-circle-1][n-circle-i-1] = matrix[circle+i][n-circle-1];
            matrix[circle+i][n-circle-1] = temp;
        }
    }
}