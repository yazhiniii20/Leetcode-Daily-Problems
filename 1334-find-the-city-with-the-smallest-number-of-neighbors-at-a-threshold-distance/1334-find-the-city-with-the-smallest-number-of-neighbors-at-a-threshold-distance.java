class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
              if(i == j) dist[i][j] = 0;
              else dist[i][j] = (int)1e9;
           }
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k] != 1e9 && dist[k][j] != 1e9){
                        dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        int city = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold)
                    count++;
            }
            if (count <= min) {
                min = count;
                city = i;
            }
        }
        return city;
    }
}