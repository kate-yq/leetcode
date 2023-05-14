import java.util.*;

public class Q187 {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> duplicate = new HashSet<>();

        int[] chars = new int[s.length()];
        for (int i=0; i<chars.length; i++){
            switch(s.charAt(i)){
                case 'A':
                    chars[i] = 0;
                    break;
                case 'G':
                    chars[i] = 1;
                    break;
                case 'T':
                    chars[i] = 2;
                    break;
                case 'C':
                    chars[i] = 3;
                    break;
            }
        }

        int num = 0;
        int R = 4;
        int L = 10;
        int left = 0;
        int right = 0;
        for (; right<s.length(); right++){
            num = num * R + chars[right];

            if (right - left == L-1){
                if (seen.contains(num)){
                    duplicate.add(s.substring(left, right+1));
                } else {
                    seen.add(num);
                }

                num -= chars[left] * Math.pow(R, L-1);
                left++;
            }
        }

        List<String> ans = new ArrayList<>(duplicate);
        return ans;
    }
}
