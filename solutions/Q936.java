import java.util.Stack;

public class Q936 {
    public int[] movesToStamp(String stamp, String target) {
        char[] letters = target.toCharArray();
        Stack<Integer> reverse_sequence = new Stack<>();

        // keep track of changed '0' to determine whether whole array changed to 0
        int count = 0;
        while (count < target.length()) {
            // if in some run, no further stamp is made
            // means the target cannot be stamped by given stamp
            // so return a empty array
            int temp = checkthrough(letters, stamp, reverse_sequence, count);
            if (temp==count){
                int[] empty = new int[0];
                return empty;
            }
            count = temp;
        }
        int[] results = new int[reverse_sequence.size()];
        for (int i = 0; i < results.length; i++) {
            results[i] = reverse_sequence.pop();
        }
        return results;
    }

    private int checkthrough(char[] letters, String stamp, Stack<Integer> reverse_sequence, int count) {
        // if char[a]-char[b] equals target
        // reverse_sequence.push(a);
        // char[a]-char[b] change to 0
        // 0/-/whatever can be treated as any letters
        // but if all 0/-/whatever will return a false
        int start = 0;
        while (start < letters.length - stamp.length() + 1) {
            boolean equal = true;
            boolean all_void = true;
            for (int i = 0; i < stamp.length(); i++) {
                if (letters[start + i] != '0') {
                    all_void = false;
                    if (letters[start + i] != stamp.charAt(i)) {
                        equal = false;
                        break;
                    }
                }
            }
            if (all_void) {
                start++;
            } else if (equal) {
                reverse_sequence.push(start);
                int end = start + stamp.length();
                while (start < end) {
                    // count the new '0' to help decide whether whole array changed to 0
                    if (letters[start] != '0'){
                        letters[start] = '0';
                        count++;
                    }
                    start++;
                }
            } else {
                start++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Q936 mS = new Q936();
        for (int i: mS.movesToStamp("abca", "aabcaca")){
            System.out.println(i);
        }
    }
}
