class Solution {
    public int mostFrequent(int[] nums, int key) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                int nxt = nums[i + 1];
                map.put(nxt, map.getOrDefault(nxt, 0) + 1);
            }
        }

        int maxFreq = -1;
        int ans = 0;

        for (int k : map.keySet()) {
            if (map.get(k) > maxFreq) {
                maxFreq = map.get(k);
                ans = k;
            }
        }

        return ans;
    }
}