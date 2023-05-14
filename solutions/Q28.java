public class Q28 {
    public int strStr(String haystack, String needle) {
        int mod = (int) Math.pow(10, 7) + 9;

        int N = 26;
        int L = needle.length();

        int NL = 1;

        for (int i=0; i<L; i++){
            NL = NL * N % mod;
        }

        int pat = 0;

        for (int i=0; i<L; i++){
            pat = (pat * N % mod +needle.charAt(i) - 'a') % mod;
        }

        int left = 0;
        int num = 0;

        for (int i=0; i<haystack.length(); i++){
            num = (num * N % mod +needle.charAt(i) - 'a') % mod;

            if (i - left == L-1){
                if (num == pat){
                    if (haystack.substring(left, i+1).equals(needle)){
                        return left;
                    }
                }

                num -= (haystack.charAt(left)-'a') * NL % mod;
                if (num < 0){
                    num += mod;
                }
                left++;
            }
        }

        return -1;
    }
}
