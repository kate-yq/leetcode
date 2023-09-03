import java.util.*;

public class Q2844 {
    public int minimumOperations(String num) {
        int index = num.length() - 1;
        HashMap<Integer, Integer> count = new HashMap<>();
        while (index >= 0) {
            if (num.charAt(index) == '0') {
                if (count.getOrDefault(0, 0) >= 1) {
                    return num.length() - index - 2;
                }
                count.put(0, count.getOrDefault(0, 0) + 1);
            } else if (num.charAt(index) == '5') {
                if (count.getOrDefault(0, 0) >= 1) {
                    return num.length() - index - 2;
                }
                count.put(5, count.getOrDefault(5, 0) + 1);
            } else if (num.charAt(index) == '2') {
                if (count.getOrDefault(5, 0) >= 1) {
                    return num.length() - index - 2;
                }
            } else if (num.charAt(index) == '7') {
                if (count.getOrDefault(5, 0) >= 1) {
                    return num.length() - index - 2;
                }
            }
            index--;
        }

        return num.length() - count.getOrDefault(0, 0);
    }
}
