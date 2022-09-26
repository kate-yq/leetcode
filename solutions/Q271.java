import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q271 {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return Character.toString((char) 258);
        }
        StringBuilder encode = new StringBuilder();
        String sep = Character.toString((char) 257);
        for (String str : strs) {
            if (str.equals("")) {
                encode.append(Character.toString((char) 256));
            } else {
                encode.append(str);
            }
            encode.append(sep);
        }
        return encode.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String empty = Character.toString((char) 258);
        if (s.equals(empty)) {
            return new ArrayList<>();
        }
        String sep = Character.toString((char) 257);
        String[] decode = s.split(sep);
        for (int i = 0; i < decode.length; i++) {
            if (decode[i].equals(Character.toString((char) 256))) {
                decode[i] = "";
            }
        }
        return Arrays.asList(decode);
    }

    public static void main(String[] args) {
        String nil = "";
        ArrayList<String> test_case = new ArrayList<>();
        test_case.add(nil);
        Q271 codec = new Q271();
        System.out.println("origin:  \'" + nil +"\'"); 
        System.out.println("encode:  " + codec.encode(test_case));
        System.out.println("decode:  ");
        for (String str : codec.decode(codec.encode(test_case))) {
            System.out.println("\'" + str + "\'");
        }
    }
}
