public class Q2600 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes){
            return k;
        } else if (k<= numOnes+numZeros){
            return numOnes;
        } else {
            return 2*numOnes + numZeros - k;
        }
    }
}