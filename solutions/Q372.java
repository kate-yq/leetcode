import java.util.LinkedList;

class Q372 {
    int mod = 1337;

    public int superPow(int a, int[] b) {
        LinkedList<Integer> b_List = new LinkedList<>();
        for (int i : b) {
            b_List.addLast(i);
        }
        return superPow(a, b_List);
    }

    public int superPow(int a, LinkedList<Integer> list) {
        if (list.isEmpty()) {
            return 1;
        }
        int last = list.getLast();
        list.removeLast();

        return (pow(a, last) * pow(superPow(a, list), 10)) % mod;
    }

    private int pow(int a, int p) {
        int ans = 1;
        a %= mod;

        for (int i = 0; i < p; i++) {
            ans *= a;
            ans %= mod;
        }

        return ans;
    }
}