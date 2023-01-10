public class Q6 {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1){
            return s;
        }
        StringBuilder ans = new StringBuilder();
        int top = 0;
        while (top<s.length()){
            ans.append(s.charAt(top));
            top = top + 2*(numRows-1);
        }
        for (int i=1; i<numRows-1; i++){
            ans.append(s.charAt(i));
            int sec = 2*(numRows-1);
            while (true){
                if (sec-i<s.length()){
                    ans.append(s.charAt(sec-i));
                } else {
                    break;
                }
                if (sec+i<s.length()){
                    ans.append(s.charAt(sec+i));
                } else {
                    break;
                }
                sec = sec + 2*(numRows-1);
            }
        }
        int bottom = numRows-1;
        while (bottom < s.length()){
            ans.append(s.charAt(bottom));
            bottom = bottom + 2*(numRows-1);
        }
        return ans.toString();
    }
}
