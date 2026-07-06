
class Solution {
    public int[][] merge(int[][] intervals) {

       
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        for (int[] current : intervals) {

           
            if (ans.isEmpty() ||
                current[0] > ans.get(ans.size() - 1)[1]) {

                ans.add(current);
            }

         
            else {
                int[] last = ans.get(ans.size() - 1);

                last[1] = Math.max(
                    last[1],
                    current[1]
                );
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}