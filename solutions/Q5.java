public class Q5 {
    public String longestPalindrome(String s) {
        int[] sub = new int[2];
        for (int i=0; i<s.length();i++){
            getPalindrome(i, i, s, sub);
            getPalindrome(i, i+1, s, sub);
        }
        return s.substring(sub[0], sub[1]);
    }

    private void getPalindrome(int i, int j, String s, int[] sub){
        if (i<0 || j>=s.length()){
            return;
        }
        while (i>=0 && j<s.length()){
            if (s.charAt(i)!=s.charAt(j)){
                break;
            }
            i--;
            j++;
        }
        if (j-i-1>sub[1]-sub[0]){
            sub[0] = i+1;
            sub[1] = j;
        }
    }

    public static void main(String[] args) {
        String test_case_1 = "babad";
        String test_case_2 = "adccbbccad";
        Q5 lP = new Q5();
        System.out.println("exp bab: "+lP.longestPalindrome(test_case_1));
        System.out.println("exp ccbbcc: "+lP.longestPalindrome(test_case_2));
    }
}
