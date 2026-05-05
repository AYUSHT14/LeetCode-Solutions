class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        if(freshOranges == 0) return 0;
        int minutes = 0;
        int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            boolean rottenOranges = false;
            for(int s=0;s<size;s++){
                int cell[] = q.poll();
                for(int d[]:dir){
                    int r = cell[0] + d[0];
                    int c = cell[1] + d[1];
                    if(r>=0 && r< rows && c>=0 && c<cols && grid[r][c] == 1){
                        grid[r][c] = 2;
                        freshOranges--;
                        q.add(new int[]{r,c});
                        rottenOranges = true;
                    }
                }
            }
            if(rottenOranges) minutes++;
        }
        return freshOranges == 0 ? minutes : -1;
    }
}