class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] rank = new int[n];
        int[] sorted = new int[n];
        for(int i=0;i<n;i++){
            sorted[i] = arr[i];
        }
        Arrays.sort(sorted);
        int r = 1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(sorted[i])){
                map.put(sorted[i],r);
                r++;
            }
        }
        for(int i=0;i<n;i++){
            rank[i] = map.get(arr[i]);
        }
        return rank;
    }
}