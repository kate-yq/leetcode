import java.util.HashMap;

public class Q34 {
    public int romanToInt(String s) {
        HashMap<Character, Integer> valuepairs = new HashMap<Character, Integer>();
        valuepairs.put('I', 1);
        valuepairs.put('V', 5);
        valuepairs.put('X', 10);
        valuepairs.put('L', 50);
        valuepairs.put('C', 100);
        valuepairs.put('D', 500);
        valuepairs.put('M', 1000);
        int[] sep = new int[s.length()];
        for (int i=0; i<sep.length; i++){
            sep[i] = valuepairs.get(s.charAt(i));
        }
        int sum = 0;
        for (int i=0; i<sep.length-1; i++){
            if (sep[i]<sep[i+1]){
                sum = sum - sep[i];
            } else {
                sum = sum + sep[i];
            }
        }
        sum += sep[sep.length-1];
        return sum;
    }
}
