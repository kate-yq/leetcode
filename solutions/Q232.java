import java.util.Stack;

public class Q232 {
    Stack<Integer> store;   //backwards
    Stack<Integer> helper;  //as queue
    
    public Q232() {
        this.store = new Stack<>();
        this.helper = new Stack<>();
    }
    
    public void push(int x) {
        store.push(x);
    }
    
    public int pop() {
        while(!store.isEmpty()){
            helper.push(store.pop());
        }
        int ans = helper.pop();
        while(!helper.isEmpty()){
            store.push(helper.pop());
        }
        return ans;
    }
    
    public int peek() {
        while(!store.isEmpty()){
            helper.push(store.pop());
        }
        int ans = helper.peek();
        while(!helper.isEmpty()){
            store.push(helper.pop());
        }
        return ans;
    }
    
    public boolean empty() {
        return store.isEmpty();
    }
}
