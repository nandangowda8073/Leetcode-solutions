
class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        int maxSum = sum;

        int left = k - 1;
        int right = n - 1;

        while (left >= 0) {

            sum -= cardPoints[left];
            sum += cardPoints[right];

            maxSum = Math.max(maxSum, sum);

            left--;
            right--;
        }

        return maxSum;
    }
}