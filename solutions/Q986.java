import java.util.ArrayList;
import java.util.List;

public class Q986 {
    // sorted
    // non-overlapting

    // 2 list: could be empty <=1000
    // size of 2 list: no relationships

    // closed intervals

        // 2 pointers in each list
        // each interval can overlap only with the intervals in the other list
        // once I find an overlap, I can drop one of them

        // search next in the same list I dropped

        // drop the one with earlier ending

        // if I checked all intervals in 1 list, then I can stop

    public int[][] intervalIntersection(int[][] lista, int[][] listb) {
        List<int[]> ans = new ArrayList<>();

        int pointers1 = 0;
        int pointers2 = 0;

        while (pointers1<lista.length && pointers2<listb.length){
            int[] overlap = new int[2];
            // [2, 4] [4, 6]
            overlap[0] = Math.max(lista[pointers1][0], listb[pointers2][0]);
            overlap[1] = Math.min(lista[pointers1][1], listb[pointers2][1]);
            if (overlap[0] <= overlap[1]){
                ans.add(overlap);
            }
            // drop the one with earlier ending
            if (lista[pointers1][1] > listb[pointers2][1]){
                pointers2++;
            } else if (lista[pointers1][1] < listb[pointers2][1]){
                pointers1++;
            } else {
                pointers1++;
                pointers2++;
            }
        }
        
        int[][] ansArr = new int[ans.size()][2];
        for (int i=0; i<ans.size(); i++){
            ansArr[i] = ans.get(i);
        }

        return ansArr;
    }
}

