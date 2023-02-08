public class Q670 {
    public int maximumSwap(int num) {
        int[] digits = new int[9];
        int i = 9;
        int copy = num;
        while(num != 0){
            i--;
            digits[i] = num % 10;
            num = num /10;
        }
        int start = i;
        int turn = 9; // first lower point
        
        while (i<8){
            if (digits[i] < digits[i+1]){
                turn = i;
                break;
            }
            i++;
        }
        if (turn == 9){
            return copy;
        }

        i = turn+1;
        int max_in = turn+1;
        while (i<9){
            // find max later num after turn
            if (digits[i] >= digits[max_in]){
                max_in = i;
            }
            i++;
        }

        while (turn >start){
            if (digits[turn-1] < digits[max_in]){
                turn--;
            } else {
                break;
            }
        }

        int temp = digits[turn];
        digits[turn] = digits[max_in];
        digits[max_in] = temp;

        int result = 0;
        for (int j =start; j<9; j++){
            result = result*10 + digits[j];
        }
        return result;
    }
}
