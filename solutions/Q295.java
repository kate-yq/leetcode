import java.util.PriorityQueue;
import java.util.Queue;

public class Q295 {
    Queue<Integer> large_half, small_half;

    public Q295() {
        this.large_half = new PriorityQueue<>(); // min heap
        this.small_half = new PriorityQueue<>(
            (num1, num2) -> num2-num1
        ); // max heap
    }
    
    public void addNum(int num) {
        this.large_half.add(num);
        if (large_half.size() - small_half.size()>1){
            int temp = large_half.poll();
            small_half.add(temp);
        } else if (!small_half.isEmpty()) {
            int temp_1 = large_half.poll();
            int temp_2 = small_half.poll();
            if (temp_1<temp_2){
                large_half.add(temp_2);
                small_half.add(temp_1);
            } else {
                large_half.add(temp_1);
                small_half.add(temp_2);
            }
        }
        return;
    }
    
    public double findMedian() {
        if (large_half.size() == small_half.size()){
            int temp_1 = large_half.poll();
            int temp_2 = small_half.poll();
            large_half.add(temp_1);
            small_half.add(temp_2);
            return (double) (temp_1+temp_2)/2;
        } else {
            int temp = large_half.poll();
            large_half.add(temp);
            return (double)temp;
        }
    }
}
