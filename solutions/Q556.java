import java.util.ArrayList;

public class Q556 {
    public int nextGreaterElement(int n) {
        if (n<10){
            return -1;
        }
        ArrayList<Integer> digits = new ArrayList<>();
        while (n>0){
            digits.add(0, n%10);
            n = n/10;
        }
        int left = digits.size()-1;  //head 
        for (int i=digits.size()-2; i>=0; i--){
            if (digits.get(i)<digits.get(i+1)){
                left = i;
                break;
            }
        }
        if (left == digits.size()-1){
            return -1;
        }
        int right = 0;
        for (int i=left+1; i<digits.size(); i++){
            if (digits.get(i)>digits.get(left)){
                right = i;
            } else {
                break;
            }
        }
        // sawp left and right
        int temp = digits.get(left);
        digits.set(left, digits.get(right));
        digits.set(right, temp);

        // reverse left+1 - end
        long ans = 0;
        for (int i=0; i<=left; i++){
            ans = ans*10 + digits.get(i);
        }
        for (int i=digits.size()-1; i>left; i--){
            ans = ans*10 + digits.get(i);
        }
        
        if (ans>Integer.MAX_VALUE){
            return -1;
        } else {
            return (int) ans;
        }
    }
}
