import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // like BFS, each time pop a word, and push all words in the list which has 1
        // diff inbetween
        // how to avoid repeating insertion?
        Queue<String> bfs = new LinkedList<String>();
        HashMap<String, Integer> length = new HashMap<>();
        length.put(beginWord, 1);
        bfs.add(beginWord);

        while (!bfs.isEmpty()) {
            String temp = bfs.poll();
            for (String word : wordList) {
                if ((!length.containsKey(word)) && climb(temp, word)) {
                    if (word.equals(endWord)) {
                        return length.get(temp) + 1;
                    } else {
                        bfs.add(word);
                        length.put(word, length.get(temp)+1);
                    }
                }
            }
        }
        return 0;
    }

    private boolean climb(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

    public static void main(String[] args){
        List<String> test_case = new ArrayList<>();
        test_case.add("hot");
        test_case.add("dot");
        test_case.add("dog");
        test_case.add("lot");
        test_case.add("log");
        test_case.add("cog");
        Q127 lL = new Q127();
        System.out.println("exp 5: "+lL.ladderLength("hit", "cog", test_case));
        System.out.println("exp 0: "+lL.ladderLength("hit", "cat", test_case));
    }
}
