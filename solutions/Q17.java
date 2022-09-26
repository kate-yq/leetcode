import java.util.ArrayList;
import java.util.List;

public class Q17 {

    public List<String> letterCombinations(String digits) {
        ArrayList<String> allcombinations = new ArrayList<String>();
        if (digits == null || digits.isEmpty()) {
            return allcombinations;
        }
        int value = Integer.valueOf(digits);
        for (String letter : MAPPINGS[value / (int) Math.pow(10, digits.length() - 1)]) {
            allcombinations.add(letter);
        }
        if (digits.length() > 1) {
            for (int index = 1; index < digits.length(); index++) {
                value = value % (int) Math.pow(10, digits.length() - index);
                int currentsize = allcombinations.size();
                for (int j = 0; j < currentsize; j++) {
                    String temp = allcombinations.remove(0);
                    for (String letter : MAPPINGS[value / (int) Math.pow(10, digits.length() - index - 1)]) {
                        allcombinations.add(temp + letter);
                    }
                }
            }
        }
        return allcombinations;
    }

    private static final String[][] MAPPINGS = {
            {}, {}, { "a", "b", "c" },
            { "d", "e", "f" },
            { "g", "h", "i" },
            { "j", "k", "l" },
            { "m", "n", "o" },
            { "p", "q", "r", "s" },
            { "t", "u", "v" },
            { "w", "x", "y", "z" }
    };

    public static void main(String[] args) {
        Q17 findalcom = new Q17();
        System.out.println("null arguement: " + findalcom.letterCombinations(""));
        for (String s : findalcom.letterCombinations(args[0])) {
            System.out.print("\'" + s + "\', ");
        }
        System.out.println(" ");
    }
}
