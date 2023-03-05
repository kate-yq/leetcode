class Q6307 {
    public int passThePillow(int n, int time) {
        int remaining  = time % (n-1);
        int count = time / (n-1);
        if (count % 2 == 0){
            return 1 + remaining;
        } else {
            return n - remaining;
        }
    }
}