class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ret = new LinkedList<Integer>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '-' ||
                    expression.charAt(i) == '+' ||
                    expression.charAt(i) == '*') {
                String part1 = expression.substring(0, i);
                String part2 = expression.substring(i + 1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                for (Integer p1 : part1Ret) {
                    for (Integer p2 : part2Ret) {
                        int c = 0;
                        switch (expression.charAt(i)) {
                            case '+':
                                c = p1 + p2;
                                break;
                            case '-':
                                c = p1 - p2;
                                break;
                            case '*':
                                c = p1 * p2;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(expression));
        }
        return ret;
    }
}