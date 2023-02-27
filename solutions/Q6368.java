public class Q6368 {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] div = new int[n];
        long pre = 0;
        for (int i=0; i<n; i++){
            pre = ((pre%m) *10)%m + word.charAt(i) - '0';
            if (pre % m == 0){
                div[i] = 1;
                pre = 0;
            }
        }
        return div;
    }

    public static void main(String[] args){
        String s = "4868438856666666";
        Q6368 da = new Q6368();
        for (int i : da.divisibilityArray(s, 6)){
            System.out.println(i);
        }
    }
}
