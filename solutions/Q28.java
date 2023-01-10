public class Q28 {
    public int strStr(String haystack, String needle) {
        int left = 0;
        while (left <= haystack.length()-needle.length()){
            boolean match = true;
            for (int i=0; i<needle.length(); i++){
                if (haystack.charAt(left+i) != needle.charAt(i)){
                    match = false;
                    break;
                }
            }
            if (match){
                return left;
            } else {
                left++;
            }
        }
        return -1;
    }
}
