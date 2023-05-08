class Q48 {
    // public void rotate(int[][] matrix) {
    //     for (int i=0; i<matrix.length/2; i++){
    //         _rotate(matrix, i);
    //     }
    // }

    // private void _rotate(int[][] matrix, int circle){
    //     int n = matrix.length;
    //     int to_change = matrix.length - circle*2 -1;
    //     for (int i=0; i<to_change; i++){
    //         int temp = matrix[circle][circle+i];
    //         matrix[circle][circle+i] = matrix[n-circle-i-1][circle];
    //         matrix[n-circle-i-1][circle] = matrix[n-circle-1][n-circle-i-1];
    //         matrix[n-circle-1][n-circle-i-1] = matrix[circle+i][n-circle-1];
    //         matrix[circle+i][n-circle-1] = temp;
    //     }
    // }


    public void rotate(int[][] matrix) {
        flipDia(matrix);
        flipVer(matrix);
    }

    private void flipDia(int[][] matrix){
        for (int i=0; i<matrix.length; i++){
            for (int j=i+1; j<matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void flipVer(int[][] matrix){
        int n = matrix.length;
        for (int i=0; i<n; i++){
            for (int j=0; j<n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}