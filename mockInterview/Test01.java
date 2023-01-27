import java.util.*;

class Test01 {
    public static void main(String[] args){
        List<String> a =new ArrayList<>();
        a.add("add");
        List<String> b = a;
        System.out.println(b);
        a.add("b");
        System.out.println(b);

        String a_String ="aaa";
        String b_String = a_String;
        System.out.println(b_String);
        a_String = "b";
        System.out.println(b_String);
    }
}