class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            int u = pre[0];
            int v = pre[1];
            adj.get(u).add(v);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,pathVisited))
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[]visited,boolean[]pathVisited){
        visited[node] = true;
        pathVisited[node] = true;
        for(int neighbour:adj.get(node)){
            if(!visited[neighbour]){
                if(dfs(neighbour,adj,visited,pathVisited))
                return true;
            }
            else if(pathVisited[neighbour]){
                return true;
            }
        }
        pathVisited[node] = false;
        return false;
    }
}