public class Q733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] need_change = new boolean[m][n];
        int[][] changedImage = new int[m][n];

        search(need_change, image, sr, sc);
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (need_change[i][j]){
                    changedImage[i][j] = color;
                } else {
                    changedImage[i][j] = image[i][j];
                }
            }
        }
        return changedImage;
    }

    private void search(boolean[][] need_change,int[][] image,int r,int c){
        if (need_change[r][c]){
            return;
        }
        need_change[r][c] = true;
        if (r>0 && image[r-1][c]==image[r][c]) {
            search(need_change,image,r-1,c);
        }
        if (r<image.length-1 && image[r+1][c]==image[r][c]){
            search(need_change,image,r+1,c);
        }
        if (c>0 && image[r][c-1]==image[r][c]){
            search(need_change,image,r,c-1);
        }
        if (c<image[0].length-1 && image[r][c+1]==image[r][c]){
            search(need_change,image,r,c+1);
        }
    }
}
