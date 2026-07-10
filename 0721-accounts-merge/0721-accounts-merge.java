class DisjointSet{
    int[] parent;
    int[] size;
    public DisjointSet(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findParent(int node){
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }
    public void unionBySize(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if(ulp_u == ulp_v) return;
        if(ulp_u < ulp_v){
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }else{
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String,Integer> mailMap = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(!mailMap.containsKey(mail)){                   
                    mailMap.put(mail,i);
                }else{
                    ds.unionBySize(i,mailMap.get(mail));
                }
            }
        }
        ArrayList<String>[] merge = new ArrayList[n];
        for(int i=0;i<n;i++){
            merge[i] = new ArrayList<String>();
        }
        for(Map.Entry<String,Integer> map : mailMap.entrySet()){
           String mail = map.getKey();
           int node = ds.findParent(map.getValue());
           merge[node].add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(merge[i].size() == 0) continue;
            Collections.sort(merge[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it : merge[i]){
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}