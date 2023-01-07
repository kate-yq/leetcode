public class Q67 {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        boolean carry = false;
        int a_index = a.length()-1;
        int b_index = b.length()-1;
        // adding
        while(a_index>=0 && b_index>=0){
            char cur = '0';
            if (a.charAt(a_index)=='0' && b.charAt(b_index)=='0'){
                if (carry) {
                    cur = '1';
                    carry = false;
                } else {
                    carry = false;
                }
            } else if (a.charAt(a_index)=='0' || b.charAt(b_index)=='0'){
                if (carry) {
                    carry = true;
                } else {
                    cur = '1';
                    carry = false;
                }
            } else {
                if (carry) {
                    cur = '1';
                    carry = true;
                } else {
                    carry = true;
                }
            }
            ans.insert(0,cur);
            a_index--;
            b_index--;
        }
        while (a_index>=0){
            char cur = '0';
            if (carry) {
                if (a.charAt(a_index)=='0'){
                    cur = '1';
                    carry = false;
                } else {
                    carry = true;
                }
            } else {
                cur = a.charAt(a_index);
            }
            ans.insert(0,cur);
            a_index--;
        }
        while (b_index>=0){
            char cur = '0';
            if (carry) {
                if (b.charAt(b_index)=='0'){
                    cur = '1';
                    carry = false;
                } else {
                    carry = true;
                }
            } else {
                cur = b.charAt(b_index);
            }
            ans.insert(0,cur);
            b_index--;
        }
        if (carry){
            ans.insert(0, '1');
        }
        return ans.toString();
    }
}
