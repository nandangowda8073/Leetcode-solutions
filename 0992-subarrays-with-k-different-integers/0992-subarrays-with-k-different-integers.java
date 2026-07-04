import java.util.*;

class Solution {

    public int atMost(int[] nums, int k) {

        if (k < 0)
            return 0;

        int l = 0;
        int r = 0;
        int cnt = 0;

        HashMap<Integer, Integer> mpp = new HashMap<>();

        while (r < nums.length) {

            mpp.put(nums[r],
                    mpp.getOrDefault(nums[r], 0) + 1);

            while (mpp.size() > k) {

                mpp.put(nums[l],
                        mpp.get(nums[l]) - 1);

                if (mpp.get(nums[l]) == 0) {
                    mpp.remove(nums[l]);
                }

                l++;
            }

            cnt += (r - l + 1);

            r++;
        }

        return cnt;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {

        return atMost(nums, k) - atMost(nums, k - 1);
    }
}