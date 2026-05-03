class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[]state = new int[n];
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(dfs(i,graph,state))
            result.add(i);
        }
        return result;
    }
    private boolean dfs(int node,int[][] graph,int[] state){
        if(state[node] != 0)
            return state[node] == 2;   // unvisited=0,visited=1,safe=2
            state[node] = 1; //visited
            for(int neighbour: graph[node]){
                if(!dfs(neighbour,graph,state))
                return false;
            }
        state[node] = 2;
        return true;
    }
}