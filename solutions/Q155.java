import java.util.Stack;

public class Q155 {
    Stack<Integer> store;
    Stack<Integer> mintrack;

    public Q155() {
        this.store = new Stack<>();
        this.mintrack = new Stack<>();
    }
    
    public void push(int val) {
        this.store.push(val);
        if (mintrack.isEmpty() || val < mintrack.peek()){
            mintrack.push(val);
        } else {
            mintrack.push(mintrack.peek());
        }
    }
    
    public void pop() {
        this.store.pop();
        this.mintrack.pop();
    }
    
    public int top() {
        return this.store.peek();
    }
    
    public int getMin() {
        return this.mintrack.peek();
    }
}
