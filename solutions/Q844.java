public class Q844 {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder s_Builder = new StringBuilder();
        StringBuilder t_Builder = new StringBuilder();

        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '#'){
                if (!s_Builder.isEmpty()){
                    s_Builder.deleteCharAt(s_Builder.length()-1);
                }
            } else {
                s_Builder.append(s.charAt(i));
            }
        }
        for (int i=0; i<t.length(); i++){
            if (t.charAt(i) == '#'){
                if (!t_Builder.isEmpty()){
                    t_Builder.deleteCharAt(t_Builder.length()-1);
                }
            } else {
                t_Builder.append(t.charAt(i));
            }
        }
        return s_Builder.toString().equals(t_Builder.toString());
    }
}
