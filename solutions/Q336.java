import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> results = new ArrayList<>();
        HashMap<String, Integer> index = new HashMap<>();
        for (int i=0; i<words.length; i++){
            index.put(words[i], i);
        }
        for (String word: words){
            String reverseWord = new StringBuilder(word).reverse().toString();
            if (index.containsKey(reverseWord) && index.get(reverseWord)!=index.get(word)){
                results.add(Arrays.asList(index.get(reverseWord),index.get(word)));
            }
            // check if there is reverse of prefix of the word
            for (String prefix : validPrefix(word)){
                String reversePrefix = new StringBuilder(prefix).reverse().toString();
                if (index.containsKey(reversePrefix) && index.get(reversePrefix)!=index.get(word)){
                    results.add(Arrays.asList(index.get(word), index.get(reversePrefix)));
                }
            }
            // check if there is reverse of suffix of the word
            for (String suffix : validSuffix(word)){
                String reverseSuffix = new StringBuilder(suffix).reverse().toString();
                if (index.containsKey(reverseSuffix) && index.get(reverseSuffix)!=index.get(word)){
                    results.add(Arrays.asList(index.get(reverseSuffix), index.get(word)));
                }
            }
        }
        return results;
    }

    private List<String> validPrefix(String word){
        List<String> prefix = new ArrayList<>();
        for (int i=0; i<word.length(); i++){
            if (isPalindrome(word, i, word.length()-1)){
                prefix.add(word.substring(0, i));
            }
        }
        return prefix;
    }

    private List<String> validSuffix(String word){
        List<String> suffix = new ArrayList<>();
        for (int i=0; i<word.length(); i++){
            if (isPalindrome(word, 0, i)){
                suffix.add(word.substring(i+1, word.length()));
            }
        }
        return suffix;
    }

    private boolean isPalindrome(String word, int left, int right){
        while (left<right){
            if (word.charAt(left)!=word.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
