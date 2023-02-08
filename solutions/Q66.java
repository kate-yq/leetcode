public class Q66 {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i=digits.length-1; i>=0; i--){
            digits[i] += carry;
            carry = digits[i] /10;
            digits[i] = digits[i] % 10;
            if (carry == 0){
                break;
            }
        }
        if (carry == 0){
            return digits;
        }
        int[] newNum = new int[digits.length+1];
        newNum[0] = carry;
        for (int i=1; i<=digits.length; i++){
            newNum[i] = digits[i-1];
        }
        return newNum;
    }
}
