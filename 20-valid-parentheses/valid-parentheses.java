class Solution {
    public boolean isValid(String s) {
        Stack<Character> bracketStack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if ((charArray[i] == '(') || (charArray[i] == '{') || (charArray[i] == '[')) {
                bracketStack.push(s.charAt(i));
            } else {
                if (bracketStack.empty()) {
                    return false;
                }
                Character lastChar = bracketStack.peek();
                if ((charArray[i] == ')' &&lastChar == '(' )|| 
                (charArray[i] == '}' && lastChar == '{') || 
                (charArray[i] == ']' && lastChar == '[')) {
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