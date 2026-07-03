class Solution {
    public int numberOfSubstrings(String s) {

        int[] hash = new int[3];
        int l = 0;
        int count = 0;
        int n = s.length();

        for (int r = 0; r < n; r++) {

            hash[s.charAt(r) - 'a']++;

            while (hash[0] > 0 && hash[1] > 0 && hash[2] > 0) {

                count += (n - r);

                hash[s.charAt(l) - 'a']--;
                l++;
            }
        }

        return count;
    }
}