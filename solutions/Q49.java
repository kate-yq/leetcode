import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> results = new ArrayList<List<String>>();
        if (strs.length==1){
            ArrayList<String> value = new ArrayList<>();
            value.add(strs[0]);
            results.add(value);
            return results;
        }
        HashMap<String, ArrayList<String>> aux_results = new HashMap<>();
        for (int i=0; i<strs.length; i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            if (aux_results.containsKey(key)){
                ArrayList<String> value = aux_results.get(key);
                value.add(strs[i]);
                aux_results.put(key,value);
            } else {
                ArrayList<String> value = new ArrayList<>();
                value.add(strs[i]);
                aux_results.put(key, value);
            }
        }
        for (String key : aux_results.keySet()){
            results.add(aux_results.get(key));
        }
        // List<List<String>> ans = new ArrayList<>(map.values());
        return results;
    }

    public static void main(String[] args) {
        String[] test_case_1 = {"eat","tea","tan","ate","nat","bat"};
        String[] test_case_2 = {"","a"};
        Q49 gA = new Q49();
        System.out.println("test case 1:");
        for (List<String> results: gA.groupAnagrams(test_case_1)){
            System.out.print("[ ");
            for (String result:results){
                System.out.print(result+",");
            }
            System.out.println(" ]");
        }
        System.out.println("test case 2:");
        for (List<String> results: gA.groupAnagrams(test_case_2)){
            System.out.print("[ ");
            for (String result:results){
                System.out.print(result+",");
            }
            System.out.println(" ]");
        }
    }
}
