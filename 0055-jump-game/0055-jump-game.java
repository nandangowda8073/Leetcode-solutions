class Solution {
    public boolean canJump(int[] nums) {

        int maxIND = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (i > maxIND) {
                return false;
            }

            maxIND = Math.max(maxIND, i + nums[i]);
        }

        return true;
    }
}