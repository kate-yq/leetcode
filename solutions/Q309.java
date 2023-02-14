class Q309 {
    public int maxProfit(int[] prices) {
        int[] sold = new int[prices.length+1];
        int[] held = new int[prices.length+1];
        int[] reset = new int[prices.length+1];
        sold[0] = Integer.MIN_VALUE;
        held[0] = Integer.MIN_VALUE;

        for (int i=0; i<prices.length; i++) {
            sold[i+1] = held[i] + prices[i];
            held[i+1] = Math.max(held[i], reset[i] - prices[i]);
            reset[i+1] = Math.max(reset[i], sold[i]);
        }

        return Math.max(sold[prices.length], reset[prices.length]);
    }
}