import java.util.HashSet;

public class Q694 {
    // number of distinct island
    // input int[][] gird  1||0
    // 1->land  0->water
    // distinct island means island in different shape
    // rotate will not count

    // 4-directionally
    // 1<= m,n <=50

    HashSet<String> shapes;
    boolean[][] visited;
    int[][] grid;

    public int numberOfDistinctIsland(int[][] grid){
        // dfs search for all connenct islands
        // main: how to represent the shape
        // using string -> Set
        // String -> dfs directions :: if 2direction sequences are equal, the shape will equal 
        // a*b sqaure, example:
        // 11\n
        // 10

        // stringBuilder to form string
        this.shapes = new HashSet<>();
        this.visited = new boolean[grid.length][grid[0].length];
        this.grid = grid;
        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j<grid[0].length; j++){
                if (grid[i][j] == 1 && !visited[i][j]){
                    StringBuilder s = new StringBuilder();
                    dfs(i,j, s);
                    shapes.add(s.toString());
                }
            }
        }
        return shapes.size();
    }

    private void dfs(int i, int j, StringBuilder s){
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            if (s.length() != 0){
                s.deleteCharAt(s.length()-1);
            }   
            return;
        }
        if (visited[i][j] || grid[i][j] == 0){
            if (s.length() != 0){
                s.deleteCharAt(s.length()-1);
            }
            return;
        }

        visited[i][j] = true;
        
        s.append('1');
        dfs(i+1, j, s);
        s.append("-1");

        s.append('2');
        dfs(i-1, j, s);
        s.append("-2");

        s.append('3');
        dfs(i, j+1, s);
        s.append("-3");

        s.append('4');
        dfs(i, j-1, s);
        s.append("-4");
    }
}

