class Solution {
    private int row;
    private int col;
    private Set<String> visited;

    public boolean exist(char[][] board, String word) {
       row = board.length;
       col = board[0].length;
       visited = new HashSet<>();

        Map<Character, Integer> count = new HashMap<>();
        for(char c : word.toCharArray()){
            count.put(c, count.getOrDefault(c,0) + 1);
        }

        if(count.getOrDefault(word.charAt(0), 0) > count.getOrDefault(word.charAt(word.length() -1),0)){
            word = new StringBuilder(word).reverse().toString();
        }

        for(int r = 0; r<row; r++){
            for(int c = 0; c<col; c++){
                if(dfs(board,word, r, c, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c , int i ){
        if(i == word.length()){
            return true;
        }
        if(r<0 || r>=row || c<0 || c>=col || 
            visited.contains(r + ","+ c) || board[r][c] != word.charAt(i)){
                return false;
        }
        visited.add(r+","+c);
        boolean result = dfs(board, word, r+1, c,i+1) ||
                        dfs(board, word, r, c+1,i+1) ||
                        dfs(board, word, r-1, c,i+1)  ||
                        dfs(board, word, r, c-1,i+1);
        visited.remove(r+","+c);
        return result;
    }
}