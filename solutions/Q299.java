import java.util.HashMap;

public class Q299 {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        String ans = "";
        int a = 0;
        int b = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c = '0'; c<='9'; c++){
            freq.put(c, 0);
        }
        for (int i =0; i<n; i++){
            if (secret.charAt(i) == guess.charAt(i)){
                a++;
            } else {
                // char in secret will increase the balance
                // if the current balance is negative, b++
                if (freq.get(secret.charAt(i))<0){
                    b++;
                }
                freq.put(secret.charAt(i), freq.get(secret.charAt(i))+1);
                // char in guess will decrease the balance
                // if the current balance is positive, b++
                if (freq.get(guess.charAt(i))>0){
                    b++;
                }
                freq.put(guess.charAt(i), freq.get(guess.charAt(i))-1);
            }
        }
        ans = Integer.toString(a) + "A" + Integer.toString(b) + "B";
        return ans;
    }
}
