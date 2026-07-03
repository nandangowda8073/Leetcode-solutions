class Solution {

    public int atMost(int[] nums, int k) {

        if (k < 0)
            return 0;

        int l = 0;
        int sum = 0;
        int cnt = 0;

        for (int r = 0; r < nums.length; r++) {

            sum += nums[r] % 2;

            while (sum > k) {
                sum -= nums[l] % 2;
                l++;
            }

            cnt += (r - l + 1);
        }

        return cnt;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
}