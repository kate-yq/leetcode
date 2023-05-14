import java.util.HashMap;

class Q567 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        
        HashMap<Character, Integer> count = new HashMap<>();
        
        for (int i=0; i<s1.length(); i++){
            count.put(s1.charAt(i), count.getOrDefault(s1.charAt(i), 0)+1);
        }

        int left = 0; 
        int right = 0;

        for (; right < s1.length()-1; right++){
            count.put(s2.charAt(right), count.getOrDefault(s2.charAt(right), 0)-1);
        }

        while (right < s2.length()){
            count.put(s2.charAt(right), count.getOrDefault(s2.charAt(right), 0)-1);
            boolean same = true;
            for (int value : count.values()){
                if (value!=0){
                    same = false;
                    break;
                }
            }
            if (same){
                return true;
            }

            count.put(s2.charAt(left), count.get(s2.charAt(left))+1);
            left++;
            right++;
        }

        return false;
    }
}