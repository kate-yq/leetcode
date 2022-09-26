public class Q14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            boolean signal = false;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i + 1) {
                    signal = true;
                    break;
                }
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    signal = true;
                    break;
                }
            }
            if (signal) {
                return prefix.toString();
            }
            prefix.append(strs[0].charAt(i));
        }
        return prefix.toString();
    }

    public static void main (String[] args){
        Q14 findprefix = new Q14();
        String prefix = findprefix.longestCommonPrefix(args);
        System.out.println("the longest prefix is: " + prefix);
    }
}
