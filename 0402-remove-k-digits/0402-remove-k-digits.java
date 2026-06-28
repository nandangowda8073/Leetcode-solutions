import java.util.*;

class Solution {

    public String removeKdigits(String num, int k) {

       
        if (k == num.length())
            return "0";

        Stack<Character> st = new Stack<>();

       
        for (char digit : num.toCharArray()) {

            
            while (!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop();
                k--;
            }

            st.push(digit);
        }

        
        while (k > 0) {
            st.pop();
            k--;
        }

        
        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        sb.reverse();

        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        if (sb.length() == 0)
            return "0";

        return sb.toString();
    }

}

    