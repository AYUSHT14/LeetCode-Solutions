class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]>q = new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[]cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            for(int[] dir:directions){
                int dr = r + dir[0];
                int dc = c + dir[1];

               if(dr >= 0 && dr < rows && dc >= 0 && dc < cols && mat[dr][dc] == -1){
                    mat[dr][dc] = mat[r][c] + 1;
                    q.add(new int[]{dr,dc});
                }
            }
        }
        return mat;
    }
}