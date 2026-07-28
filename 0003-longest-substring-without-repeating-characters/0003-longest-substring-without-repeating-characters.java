class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low = 0;
        int high = 0;
        int res = 0;
        int n = s.length();
        int[] freq = new int[128];

        for (high = 0; high < n; high++) {
            freq[s.charAt(high)]++;

            while (freq[s.charAt(high)] > 1) {
                freq[s.charAt(low)]--;
                low++;
            }

            int len = high - low + 1;
            res = Math.max(res, len);
        }

        return res;
    }
}