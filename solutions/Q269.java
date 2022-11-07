import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

class Q269 {
    public String alienOrder(String[] words) {
        // build a graph to realise topolgical search
        // print the node with no others pointing to it, then delete it
        // repeat the above process

        HashMap<Character, List<Character>> adj_list = new HashMap<>();
        HashMap<Character, Integer> inbound = new HashMap<>();
        for (String word : words){
            for (char c : word.toCharArray()){
                inbound.put(c, 0);
                adj_list.put(c, new ArrayList<Character>());
            }
        }

        // build all edge
        for (int i=0; i<words.length-1; i++){
            String word_1 = words[i];
            String word_2 = words[i+1];
            if (word_1.startsWith(word_2) && word_1.length()>word_2.length()){
                return "";
            }
            for (int j=0; j<word_1.length() && j<word_2.length(); j++){
                if (word_1.charAt(j)!=word_2.charAt(j)){
                    adj_list.get(word_1.charAt(j)).add(word_2.charAt(j));
                    inbound.put(word_2.charAt(j), inbound.get(word_2.charAt(j))+1);
                    break;
                }
            }
        }

        // bfs or topological search
        StringBuilder result = new StringBuilder();
        Queue<Character> bfs = new LinkedList<>();
        for (char c: inbound.keySet()){
            if (inbound.get(c)==0){
                bfs.add(c);
            }
        }
        while (!bfs.isEmpty()){
            char front = bfs.poll();
            result.append(front);
            for (char next : adj_list.get(front)){
                inbound.put(next, inbound.get(next)-1);
                if (inbound.get(next)==0){
                    bfs.add(next);
                }
            }
        }

        if (result.length()< inbound.size()){
            return "";
        }
        return result.toString();
    }
}