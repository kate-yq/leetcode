public class Q647 {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i=0; i<s.length();i++){
            count = getPalindrome(i, i, s, count);
            count = getPalindrome(i, i+1, s, count);
        }
        return count;
    }

    private int getPalindrome(int i, int j, String s, int count){
        while (i>=0 && j<s.length()){
            if (s.charAt(i)!=s.charAt(j)){
                break;
            }
            count++;
            i--;
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        String test_case_1 = "aaa";
        String test_case_2 = "adccbbccad";
        Q647 cS = new Q647();
        System.out.println("exp 6: "+cS.countSubstrings(test_case_1));
        System.out.println("exp 15: "+cS.countSubstrings(test_case_2));
    }
}
