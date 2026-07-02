class Solution {
    public int lengthOfLongestSubstring(String s) {

        int[] hash = new int[256];

       
        for (int i = 0; i < 256; i++) {
            hash[i] = -1;
        }

        int l = 0;
        int maxLen = 0;

        for (int r = 0; r < s.length(); r++) {

            char ch = s.charAt(r);

            
            if (hash[ch] != -1 && hash[ch] >= l) {
                l = hash[ch] + 1;
            }

            hash[ch] = r;
            int len = r - l + 1;

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}