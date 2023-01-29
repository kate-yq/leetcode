import java.util.LinkedList;

public class Q1762 {
    public int[] findBuildings(int[] heights) {
        LinkedList<Integer> buildings = new LinkedList<>();

        int highest = 0;
        for (int i=heights.length-1; i>=0; i--){
            if (heights[i] > highest){
                highest = heights[i];
                buildings.addLast(i);
            }
        }
        int[] ans = new int[buildings.size()];
        for (int i=0; i<ans.length; i++){
            ans[i] = buildings.removeLast();
        }
        return ans;
    }
}
