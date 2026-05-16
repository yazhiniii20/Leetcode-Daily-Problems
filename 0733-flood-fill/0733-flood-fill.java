class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int original = image[sr][sc];
        if(original == color) return image;
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(sr,sc));
        image[sr][sc] = color;
        while(!q.isEmpty()){
            Pair<Integer,Integer> pair = q.poll();
            int i = pair.getKey();
            int j = pair.getValue();
            changeColor(i+1,j,m,n,image,q,color,original);
            changeColor(i-1,j,m,n,image,q,color,original);
            changeColor(i,j+1,m,n,image,q,color,original);
            changeColor(i,j-1,m,n,image,q,color,original);         
        }
        return image;
    }
    static void changeColor(int i,int j,int m,int n,int[][] image,Queue<Pair<Integer,Integer>> q,int color,int original){
        if(i<0 || i >= m || j<0 || j>=n || image[i][j] != original){
            return;
        }
            q.add(new Pair<>(i,j));
            image[i][j] = color;
    }
}