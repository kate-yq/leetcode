import java.util.Stack;

public class Q735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> results = new Stack<>();
        for (int i=0; i<asteroids.length; i++){
            while (true){
                if (results.size()==0){
                    results.add(asteroids[i]);
                    break;
                }
                if (results.peek()>0 && asteroids[i]<0){
                    if (results.peek() < -asteroids[i]){
                        results.pop();
                    } else if (results.peek() == -asteroids[i]){
                        results.pop();
                        break;
                    } else {
                        break;
                    }
                } else {
                    results.add(asteroids[i]);
                    break;
                }
            }
        }
        int[] result = new int[results.size()];
        for (int i=result.length-1; i>=0; i--){
            result[i]=results.pop();
        }
        return result;
    }
}
