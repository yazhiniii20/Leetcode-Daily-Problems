class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
       Map<Integer,Set<Integer>> map = new HashMap<>();
       for(int[] seats : reservedSeats){
          map.putIfAbsent(seats[0],new HashSet<>());
          map.get(seats[0]).add(seats[1]);
       }
       int answer = (n - map.size())*2;
       for(Set<Integer> reserved : map.values()){
          boolean left = !reserved.contains(2)&&!reserved.contains(3)&&
          !reserved.contains(4)&&!reserved.contains(5);
          boolean middle = !reserved.contains(4)&&!reserved.contains(5)&&
          !reserved.contains(6)&&!reserved.contains(7);
          boolean right = !reserved.contains(6)&&!reserved.contains(7)&&
          !reserved.contains(8)&&!reserved.contains(9);
          if(left && right) answer += 2;
          else if(left || right || middle) answer += 1;
       }
       return answer;
    }
}