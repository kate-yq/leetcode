public class Q672 {
    public int flipLights(int n, int presses) {
        // button 1 + 2 == button 3
        // so only 8 cases: all on, 1, 2, 3, 4, 1+4, 2+4, 3+4
        if (presses == 0){
            return 1;
        }
        if (n == 1){
            return 2; 
        }
        if (n == 2 && presses == 1){
            return 3;
        }
        if (n == 2){
            return 4;
        }
        if (presses == 1){
            return 4;
        }
        if (presses == 2){
            return 7;
        }
        return 8;
    }
}
