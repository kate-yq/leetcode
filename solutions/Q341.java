// import java.util.*;

// public class Q341 implements Iterator<Integer>{
//     // private LinkedList<NestedInteger> list;

    // public Q341(List<NestedInteger> nestedList) {
    //     this.list = new LinkedList<>(nestedList);
    // }

    // @Override
    // public Integer next() {
    //     return list.removeFirst().getInteger();
    // }

    // @Override
    // public boolean hasNext() {
    //     while (!list.isEmpty() && !list.getFirst().isInteger()){
    //         List<NestedInteger> fistElement = list.removeFirst();
    //         for (int i = fistElement.size()-1; i>=0; i--){
    //             list.addFirst(fistElement.get(i));;
    //         }
    //     }

    //     return !list.isEmpty();
    // }
// }
