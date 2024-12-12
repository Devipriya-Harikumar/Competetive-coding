class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq = new int[26];

        // Initialize frequency array for s1 and the first window in s2
        for (char c : s1.toCharArray()) freq[c - 'a']--;
        for (int i = 0; i < s1.length(); i++) freq[s2.charAt(i) - 'a']++;

        // Count non-zero differences
        int diff = 0;
        for (int count : freq) {
            if (count != 0) diff++;
        }

        // Sliding window
        for (int i = s1.length(); i < s2.length(); i++) {
            if (diff == 0) return true;

            int addIdx = s2.charAt(i) - 'a';
            int removeIdx = s2.charAt(i - s1.length()) - 'a';

            // Update diff for the new character added
            if (freq[addIdx] == 0) diff++;
            freq[addIdx]++;
            if (freq[addIdx] == 0) diff--;

            // Update diff for the character removed
            if (freq[removeIdx] == 0) diff++;
            freq[removeIdx]--;
            if (freq[removeIdx] == 0) diff--;
        }

        return diff == 0;
    }
}