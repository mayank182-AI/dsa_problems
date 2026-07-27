class Solution {
    public int longestKSubstr(String s, int k) {

        int low = 0;
        int res = -1;
        int distinct = 0;
        int n = s.length();
        int[] freq = new int[26];

        for (int high = 0; high < n; high++) {

            int idx = s.charAt(high) - 'a';

            if (freq[idx] == 0) {
                distinct++;
            }
            freq[idx]++;

            while (distinct > k) {
                int leftIdx = s.charAt(low) - 'a';
                freq[leftIdx]--;

                if (freq[leftIdx] == 0) {
                    distinct--;
                }

                low++;
            }

            if (distinct == k) {
                int len = high - low + 1;
                res = Math.max(res, len);
            }
        }

        return res;
    }
}