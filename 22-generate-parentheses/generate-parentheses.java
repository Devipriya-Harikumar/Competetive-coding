class Solution {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n, "");
        return result;
    }

    private void backtrack(int open, int closed, int n, String s) {
        if (open == closed && closed == n) {
            result.add(s);
            return;
        }
        if (open < n) {
            backtrack(open + 1, closed, n, s + "(");
        }
        if (closed < open) {
            backtrack(open, closed + 1, n, s + ")");
        }
    }

}