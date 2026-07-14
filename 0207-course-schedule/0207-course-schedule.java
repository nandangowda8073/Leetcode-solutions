class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }

        int[] state = new int[numCourses];
       

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (dfs(i, adj, state))
                    return false;
            }
        }

        return true;
    }

    private boolean dfs(int node,
                        ArrayList<ArrayList<Integer>> adj,
                        int[] state) {

        state[node] = 1;  

        for (int neighbor : adj.get(node)) {

            if (state[neighbor] == 1)
                return true;     

            if (state[neighbor] == 0) {
                if (dfs(neighbor, adj, state))
                    return true;
            }
        }

        state[node] = 2;     
        return false;
    }
}