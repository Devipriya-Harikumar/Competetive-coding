class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magHash = new HashMap<>();

        for(char c : magazine.toCharArray()) {
            magHash.put(c, magHash.getOrDefault(c,0) + 1);
        }

        for(char c: ransomNote.toCharArray()) {
            if(!magHash.containsKey(c) || magHash.get(c) <= 0) {
                return false;
            }
            magHash.put(c,magHash.get(c) - 1);
        }
        return true;
    }
}