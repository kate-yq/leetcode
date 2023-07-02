import java.util.HashSet;

public class Q380 {
    HashSet<Integer> set;

    public Q380() {
        this.set = new HashSet<>();
    }

    public boolean insert(int val) {
        if (this.set.contains(val)) {
            return false;
        }
        set.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!set.contains(val)) {
            return false;
        }
        set.remove(val);
        return true;
    }

    public int getRandom() {
        int index = (int) Math.floor(Math.random() * this.set.size());
        return (int) set.toArray()[index];
    }
}
