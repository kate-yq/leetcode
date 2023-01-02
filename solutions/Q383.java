import java.util.HashMap;

public class Q383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i=0; i<ransomNote.length(); i++){
            if (count.containsKey(ransomNote.charAt(i))){
                count.put(ransomNote.charAt(i), count.get(ransomNote.charAt(i))+1);
            } else {
                count.put(ransomNote.charAt(i), 1);
            }
        }
        int sum = ransomNote.length();
        for (int i=0; i<magazine.length(); i++){
            if (count.containsKey(magazine.charAt(i))){
                if (count.get(magazine.charAt(i))>0){
                count.put(magazine.charAt(i), count.get(magazine.charAt(i))-1);
                sum--;
                }
            }
        }

        return sum==0;
    }
}
