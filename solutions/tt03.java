import java.util.*;

public class tt03 {
    public static List<List<String>> helper03(String[] send_orders, String[] pickup_orders) {
        Map<String, PriorityQueue<Pair<String, String>>> send = new HashMap<>();
        //send_orders
        for (String cur : send_orders) {
            String[] currentArray = cur.split(",");
            String key = currentArray[1] + currentArray[3];
            Pair<String, String> currentPair = new Pair<String, String>(currentArray[0], currentArray[2]);
            PriorityQueue<Pair<String, String>> currentPQ = send.getOrDefault(key, new PriorityQueue<Pair<String, String>>((a,b) -> a.getValue().compareTo(b.getValue())));
            currentPQ.offer(currentPair);
            send.put(key, currentPQ);
        }
        //pick_orders
        Map<String, PriorityQueue<Pair<String, String>>> pick = new HashMap<>();
        for (String cur : pickup_orders) {
            String[] currentArray = cur.split(",");
            String key = currentArray[1] + currentArray[3];
            Pair<String, String> currentPair = new Pair<String, String>(currentArray[0], currentArray[2]);
            PriorityQueue<Pair<String, String>> currentPQ = pick.getOrDefault(key, new PriorityQueue<Pair<String, String>>((a,b) -> a.getValue().compareTo(b.getValue())));
            currentPQ.offer(currentPair);
            pick.put(key, currentPQ);
        }
        List<String> single = new ArrayList<>();
        List<String> pairOrder = new ArrayList<>();
        for(String key : pick.keySet()) {
            if (!send.containsKey(key)) {
                PriorityQueue<Pair<String, String>> tmp = pick.get(key);
                while (!tmp.isEmpty()) {
                    single.add(tmp.poll().getKey());
                }
            } else {
                PriorityQueue<Pair<String, String>> tmpSend = send.get(key);
                PriorityQueue<Pair<String, String>> tmpPick = pick.get(key);
                Stack<Pair<String, String>> stack = new Stack<>();
                while (!tmpPick.isEmpty() && !tmpSend.isEmpty()) {
                    String picktime = tmpPick.peek().getValue(); 
                    if (picktime.compareTo(tmpSend.peek().getValue()) < 0) {
                        single.add(tmpPick.poll().getKey());
                    } else {
                        Pair<String, String> curPairSend = tmpSend.poll();
                        while(!tmpSend.isEmpty() && picktime.compareTo(tmpSend.peek().getValue()) >= 0) {
                            stack.add(curPairSend);
                            curPairSend = tmpSend.poll();
                        }
                        pairOrder.add(curPairSend.getKey() + "->" + tmpPick.poll().getKey());
                    }
                    while (!tmpPick.isEmpty() && !stack.isEmpty()) {
                        pairOrder.add(stack.pop().getKey() + "->" + tmpPick.poll().getKey());
                    }
                }
                while (!stack.isEmpty()) {
                    single.add(stack.pop().getKey());
                } 
                while (!tmpPick.isEmpty()) {
                    single.add(tmpPick.poll().getKey());
                }
                while (!tmpSend.isEmpty()) {
                    single.add(tmpSend.poll().getKey());
                }
            }
        }
        for(String key : send.keySet()) {
            if (!pick.containsKey(key)) {
                PriorityQueue<Pair<String, String>> tmp = send.get(key);
                while (!tmp.isEmpty()) {
                    single.add(tmp.poll().getKey());
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        res.add(pairOrder);
        res.add(single);
        return res;
    }
    
    public static void main(String[] args) throws Exception {
        String[] send_orders = new String[7];
        send_orders[0] = "s_order1,1,2022-02-11 12:00:00,airport1";
        send_orders[1] = "s_order2,1,2022-02-11 12:30:00,airport1";
        send_orders[2] = "s_order3,1,2022-02-11 12:10:00,airport1";
        send_orders[3] = "s_order4,2,2022-02-12 12:30:00,airport2";
        send_orders[4] = "s_order5,2,2022-02-12 18:27:00,airport2";
        send_orders[5] = "s_order6,1,2022-02-12 19:30:00,airport2";
        send_orders[6] = "s_order7,2,2022-02-12 20:15:00,airport2";
        String[] pick_orders = new String[7];
        pick_orders[0] = "p_order1,1,2022-02-11 12:20:00,airport1";
        pick_orders[1] = "p_order2,2,2022-02-11 14:30:00,airport1";
        pick_orders[2] = "p_order3,2,2022-02-12 12:45:00,airport2";
        pick_orders[3] = "p_order4,2,2022-02-12 12:15:00,airport2";
        pick_orders[4] = "p_order5,2,2022-02-12 19:30:00,airport2";
        pick_orders[5] = "p_order6,2,2022-02-12 20:30:00,airport2";
        pick_orders[6] = "p_order7,2,2022-02-12 20:00:00,airport2";
        System.out.println(helper03(send_orders, pick_orders));
    }
}
