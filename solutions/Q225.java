import java.util.*;

public class Q225 {
    Queue<Integer> queue;
    int topElement;

    public Q225() {
        queue  = new LinkedList<>();
        topElement = 0;
    }
    
    public void push(int x) {
        queue.offer(x);
        topElement = x;
    }
    
    public int pop() {
        int size = queue.size();
        while (size > 2){
            queue.offer(queue.poll());
            size--;
        }
        topElement = queue.peek();
        queue.offer(queue.poll());
        return queue.poll();
    }
    
    public int top() {
        return topElement;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}
