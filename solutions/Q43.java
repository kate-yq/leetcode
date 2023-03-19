public class Q43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        if (num1.length() < num2.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        for (int i=num2.length()-1; i>=0; i--){
            String cur = singleMultiply(num1, num2.charAt(i));
            add(ans, cur, num2.length()-1-i);
        }
        return ans.toString();
    }

    private String singleMultiply(String a, char b){
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for (int i=a.length()-1; i>=0; i--){
            int cur = (a.charAt(i)-'0') * (b-'0');
            ans.insert(0, (cur+carry)%10);
            carry = (cur+carry)/10;
        }
        if (carry != 0){
            ans.insert(0, carry);
        }
        return ans.toString();
    }

    private void add(StringBuilder base, String cur, int numberOfZero){
        if (base.length() <= numberOfZero){
            for (int i = 0; i<numberOfZero-base.length(); i++){
                base.insert(0, '0');
            }
            base.insert(0, cur);
            return;
        }

        int carry = 0;
        int j = cur.length()-1;
        for (int i=base.length()-numberOfZero-1; i>=0; i--){
            int added = (base.charAt(i)-'0') + (cur.charAt(j) -'0');
            base.deleteCharAt(i);
            base.insert(i, (added+carry)%10);
            carry = (added+carry)/10;
            j--;
        }
        while(j>=0){
            base.insert(0, (cur.charAt(j) -'0'+carry)%10);
            carry = (cur.charAt(j) -'0' + carry)/10;
            j--;
        }
        if (carry != 0){
            base.insert(0, carry);
        }
    }
}
