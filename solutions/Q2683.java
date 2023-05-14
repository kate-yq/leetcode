public class Q2683 {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        boolean[] oringinal = new boolean[n];

        for (int i = 0; i<n-1; i++){
            if (derived[i] == 1){
                oringinal[i+1] = !oringinal[i];
            } else {
                oringinal[i+1] = oringinal[i];
            }
        }

        boolean next = false;

        if (derived[n-1] == 1){
            next = !oringinal[n-1];
        } else {
            next = oringinal[n-1];
        }

        return next == oringinal[0];
    }
}
