class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh=0;
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
             if(grid[i][j] == 1){
                fresh++;
             }else if(grid[i][j] == 2){
                q.offer(new Pair<>(i,j));
             }
            }
        }
        int minutes = 0;
        while(fresh > 0 && !q.isEmpty()){
           minutes++;
           int size = q.size();
           while(fresh > 0 && size-- > 0){
            Pair<Integer,Integer> pair = q.poll();
            int i = pair.getKey();
            int j = pair.getValue();
            if(check(i+1,j,m,n,q,grid)) fresh--;
            if(check(i-1,j,m,n,q,grid)) fresh--;
            if(check(i,j+1,m,n,q,grid)) fresh--;
            if(check(i,j-1,m,n,q,grid)) fresh--;
           }
        }
        return (fresh == 0)?minutes:-1;
    }
    static boolean check(int i,int j,int m,int n,Queue<Pair<Integer,Integer>> q,int[][]grid){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1){
            return false;
        }
        q.add(new Pair<>(i,j));
        grid[i][j] = 2;
        return true;
    }
}