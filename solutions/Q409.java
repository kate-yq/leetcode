import java.util.HashMap;

public class Q409 {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            if (count.containsKey(s.charAt(i))){
                count.put(s.charAt(i),count.get(s.charAt(i))+1);
            } else {
                count.put(s.charAt(i),1);
            }
        }
        int result = 0;
        for (char character : count.keySet()){
            result += count.get(character)/2 *2;
            if (result % 2 == 0 && count.get(character) % 2 == 1){
                result ++;
            }
        }
        return result;
    }
}
