public class Q277 {
    // 4 kinds of relartion ship
    // a knows b, b knows a, both not celeb
    // a knows b, b not know a, a not celeb
    // a not know b, b knows a, b not celeb
    // a not know b, b not know a, both not celeb

    public int findCelebrity(int n) {
        int candidate = 0;
        for (int other = 1; other < n; other++){
            if (knows(candidate, other)  || !knows(other, candidate)){
                // candicate is not celeb
                candidate = other;
            }
        }

        for (int other = 0; other < n; other++){
            if (other == candidate){
                continue;
            }
            if (!knows(other, candidate) || knows(candidate, other)){
                return -1;
            }
        }

        return candidate;
    }

    private boolean knows(int a, int b){
        return true;
    }
}
