import java.util.HashMap;

public class Q953 {
    public boolean isValidDictionary(String[] wordlist, String seq){
        if (wordlist.length == 1){
            return true;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i<seq.length(); i++){
            map.put(seq.charAt(i), i);
        }

        for (int i=0; i<wordlist.length-1; i++){
            int index =0;
            while(index<wordlist[i].length() && index<wordlist[i+1].length()){
                if (wordlist[i].charAt(index) != wordlist[i+1].charAt(index)){
                    if (map.get(wordlist[i].charAt(index)) > map.get(wordlist[i+1].charAt(index))){
                        return false;
                    } else {
                        // with && width
                        break;
                    }
                }
                index++;
            }
            // index go beyond one of the words
            // len length
            if (index == wordlist[i+1].length() && index<wordlist[i].length()){
                return false;
            }
        }
        return true;
    }
}
