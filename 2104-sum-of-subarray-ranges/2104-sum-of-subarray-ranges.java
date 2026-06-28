import java.util.*;

class Solution {

    public long subArrayRanges(int[] nums) {
        return getMax(nums) - getMin(nums);
    }

    long getMin(int[] nums) {
        int n = nums.length;
        int[] prev = prevSmaller(nums);
        int[] next = nextSmaller(nums);

        long sum = 0;
        for (int i = 0; i < n; i++)
            sum += (long) nums[i] * (i - prev[i]) * (next[i] - i);

        return sum;
    }

    long getMax(int[] nums) {
        int n = nums.length;
        int[] prev = prevGreater(nums);
        int[] next = nextGreater(nums);

        long sum = 0;
        for (int i = 0; i < n; i++)
            sum += (long) nums[i] * (i - prev[i]) * (next[i] - i);

        return sum;
    }

    int[] prevSmaller(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i])
                st.pop();

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    int[] nextSmaller(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i])
                st.pop();

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }

    int[] prevGreater(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i])
                st.pop();

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    int[] nextGreater(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i])
                st.pop();

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
}