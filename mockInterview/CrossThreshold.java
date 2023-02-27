import java.util.Arrays;

class CrossThreshold {
    public int getMaxBarrier(int[] initialEnergy, int th){
        Arrays.sort(initialEnergy);
        int n = initialEnergy.length;
        // binary search for barrier
        int bL = 0;
        int bR = initialEnergy[n-1];
        while (bL < bR -1){
            int bM = bL + (bR-bL)/2;
            // binary search for starting point of current barrier
            int left = 0;
            int right = n-1;
            while (left < right - 1){
                int mid = left + (right - left)/2; 
                if (bM < initialEnergy[mid]){
                    right = mid;
                } else if (bM > initialEnergy[mid]){
                    left = mid;
                } else {
                    right = mid + 1;
                    break;
                }
            }

            // add energy with current barrier
            int sum = 0;
            for (int i = right; i<n; i++){
                sum = sum + initialEnergy[i] - bM;
            }

            // adjust boundaries 
            if (sum > th){
                bL = bM;
            } else if (sum < th){
                bR = bM;
            } else {
                return bM;
            }
        }
        return bL;
    }
}