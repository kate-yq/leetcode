import java.util.ArrayList;

public class Gridland {
    ArrayList<String> allPaths;

    public String[] getSaftPaths(int x, int y, int[] journeys){
        this.allPaths = new ArrayList<>();
        int n = journeys.length;
        StringBuilder comb = new StringBuilder();

        generatePath(comb, x, y, 0, 0);

        String[] safePaths = new String[n];
        for (int i=0; i<n; i++){
            safePaths[i] = allPaths.get(journeys[i]);
        }
        return safePaths;
    }

    private void generatePath(StringBuilder comb, int v, int h, int curV, int curH){
        if (comb.length() == v+h){
            allPaths.add(comb.toString());
            return;
        }
        
        if (h > curH){
            comb.append('H');
            generatePath(comb, v, h, curV, curH+1);
            comb.deleteCharAt(comb.length()-1);
        }
        if (v > curV){
            comb.append('V');
            generatePath(comb, v, h, curV+1, curH);
            comb.deleteCharAt(comb.length()-1);
        }
        return;
    }

    public static void main(String[] args){
        Gridland gg = new Gridland();
        String[] res = gg.getSaftPaths(2, 2, new int[]{0,1,2,3,4,5});
        for (String s : res){
            System.out.println(s);
        }
    }
}
