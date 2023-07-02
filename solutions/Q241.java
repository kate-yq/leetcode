import java.util.*;

class Q241 {
    HashMap<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1, expression.length());

                List<Integer> leftRes = diffWaysToCompute(left);
                List<Integer> rightRes = diffWaysToCompute(right);

                for (int l : leftRes) {
                    for (int r : rightRes) {
                        if (expression.charAt(i) == '+') {
                            res.add(l + r);
                        } else if (expression.charAt(i) == '-') {
                            res.add(l - r);
                        } else if (expression.charAt(i) == '*') {
                            res.add(l * r);
                        }
                    }
                }
            }
        }

        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }

        memo.put(expression, res);
        return res;
    }
}