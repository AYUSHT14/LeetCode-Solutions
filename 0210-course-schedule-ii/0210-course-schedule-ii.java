class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] pre:prerequisites){
            int u = pre[0];
            int v = pre[1];
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] preVisited = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,preVisited,st))
                return new int[0];
            }
        }
        int[] result = new int[numCourses];
        int index = 0;
        while(!st.empty()){
            result[index++] = st.pop();
        }
        return result;
    }
    private boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited,boolean[] preVisited,Stack<Integer> st){
        visited[node] = true;
        preVisited[node] = true;
        for(int neighbour:adj.get(node)){
            if(!visited[neighbour]){
                if(dfs(neighbour,adj,visited,preVisited,st))
                return true;
            }
            else if(preVisited[neighbour]){
                return true;
            }
        }
        preVisited[node] = false;
        st.push(node);
        return false;
    }
}