import java.util.*;

class Q1125 {
    int target;
    HashMap<String, Integer> bit;
    int min;
    LinkedList<Integer> temp;

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        this.target = 0;
        this.bit = new HashMap<>();

        for (int i = 0; i < req_skills.length; i++) {
            int curBit = 1 << i;
            target |= curBit;
            bit.put(req_skills[i], curBit);
        }

        this.min = people.size() + 1;
        this.temp = new LinkedList<>();

        int[] peopleBit = new int[people.size()];
        HashSet<Integer> set = new HashSet<>();

        // remove same people
        for (int i = 0; i < peopleBit.length; i++) {
            for (String s : people.get(i)) {
                peopleBit[i] |= bit.get(s);
            }
            if (set.contains(peopleBit[i])) {
                peopleBit[i] = 0;
            } else {
                set.add(peopleBit[i]);
            }
        }

        // remove smaller people
        if (set.contains(0)) {
            set.remove(0);
        }
        for (int i = 0; i < peopleBit.length; i++) {
            if (peopleBit[i] == 0) {
                continue;
            }
            for (int s : set) {
                if (peopleBit[i] < s && (peopleBit[i] & s) == peopleBit[i]) {
                    set.remove(peopleBit[i]);
                    peopleBit[i] = 0;
                    break;
                }
            }
        }

        backtrack(0, 0, peopleBit, new LinkedList<>());

        int[] ans = new int[temp.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = temp.removeFirst();
        }

        return ans;
    }

    private void backtrack(int curIn, int curSet, int[] people, LinkedList<Integer> path) {
        if (curSet == target) {
            if (path.size() < min) {
                this.temp = new LinkedList<>(path);
                min = path.size();
            }
            return;
        }

        if (curIn >= people.length) {
            return;
        }

        // not choose
        backtrack(curIn + 1, curSet, people, path);

        if (people[curIn] > 0) {
            path.add(curIn);
            curSet |= people[curIn];
            // choose
            backtrack(curIn + 1, curSet, people, path);
            path.removeLast();
        }
    }
}