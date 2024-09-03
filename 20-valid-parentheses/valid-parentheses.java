class Solution {
    public boolean isValid(String s) {
        Stack<Character> bracketStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '(') || (s.charAt(i) == '{') || (s.charAt(i) == '[')) {
                bracketStack.push(s.charAt(i));
            } else {
                if (bracketStack.empty()) {
                    return false;
                }
                if (s.charAt(i) == ')' && bracketStack.peek() == '(') {
                    bracketStack.pop();
                } else if (s.charAt(i) == '}' && bracketStack.peek() == '{') {
                    bracketStack.pop();
                } else if (s.charAt(i) == ']' && bracketStack.peek() == '[') {
                    bracketStack.pop();
                } else {
                    return false;
                }
            }
        }
        if (bracketStack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}