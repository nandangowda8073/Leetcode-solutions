import java.util.*;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        backtrack(result, new StringBuilder(), num.toCharArray(), target, 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb, char[] num, int target, int index, long eval, long prev) {
        if (index == num.length) {
            if (eval == target) {
                result.add(sb.toString());
            }
            return;
        }

        long currentNum = 0;
        int len = sb.length();

        for (int i = index; i < num.length; i++) {
            if (i != index && num[index] == '0') break;

            currentNum = currentNum * 10 + (num[i] - '0');

            if (index == 0) {
                sb.append(currentNum);
                backtrack(result, sb, num, target, i + 1, currentNum, currentNum);
                sb.setLength(len);
            } else {
        
                sb.append("+").append(currentNum);
                backtrack(result, sb, num, target, i + 1, eval + currentNum, currentNum);
                sb.setLength(len);

                
                sb.append("-").append(currentNum);
                backtrack(result, sb, num, target, i + 1, eval - currentNum, -currentNum);
                sb.setLength(len);

                sb.append("*").append(currentNum);
                backtrack(result, sb, num, target, i + 1, (eval - prev) + (prev * currentNum), prev * currentNum);
                sb.setLength(len);
            }
        }
    }
}