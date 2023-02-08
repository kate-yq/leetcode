public class Q680 {
    public boolean validPalindrome(String s) {
        StringBuilder copy1 = new StringBuilder(s);
        StringBuilder copy2 = new StringBuilder(s);
        for (int i=0; i<=s.length()/2; i++){
            if (s.charAt(i)!= s.charAt(s.length()-1-i)){
                copy1.deleteCharAt(i);
                copy2.deleteCharAt(s.length()-1-i);
                return isPalindrome(copy1, i) || isPalindrome(copy2, i);
            }
        }
        return true;
    }

    private boolean isPalindrome(StringBuilder s, int start){
        for (int i=start; i<=s.length()/2; i++){
            if (s.charAt(i)!= s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
