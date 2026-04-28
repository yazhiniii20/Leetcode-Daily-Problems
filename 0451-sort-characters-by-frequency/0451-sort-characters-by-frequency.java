class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        StringBuilder res = new StringBuilder();
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(
            (a,b) -> b.getValue() - a.getValue()
        );
        pq.addAll(map.entrySet());
        while(!pq.isEmpty()){
         Map.Entry<Character,Integer> entry = pq.poll();
         res.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }
        return res.toString();
    }
   }