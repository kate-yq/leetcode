public class Q2660 {
    public int isWinner(int[] player1, int[] player2) {
        int n = player1.length;

        int score1 = 0;
        int score2 = 0;

        for (int i=0; i<n; i++){
            score1 += player1[i];
            if ((i>=1 && player1[i-1] == 10) || (i>=2 &&player1[i-2]==10)){
                score1 += player1[i];
            }
            score2 += player2[i];
            if ((i>=1 && player2[i-1] == 10) || (i>=2 &&player2[i-2]==10)){
                score2 += player2[i];
            }
        }

        if (score1 > score2){
            return 1;
        } else if (score1 < score2){
            return 2;
        } else {
            return 0;
        }
    }
}
