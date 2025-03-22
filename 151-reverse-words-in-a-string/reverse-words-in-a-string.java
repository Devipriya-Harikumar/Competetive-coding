class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        String out = "";
        for (int i =arr.length-1; i>=0; i--) {
            if(!arr[i].trim().equals("")){
                out = out + arr[i].trim() + " ";
            }
        }
        out=out.trim();
        return out;
    }
}