class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while(n != 1 && !seen.contains(n)){
            seen.add(n);
            n = squareDigits(n);           
        }
        return (n == 1)?true:false;
    }
    private static int squareDigits(int n){
      int sum = 0;
      while(n > 0){
        sum = sum + (n%10)*(n%10);
        n = n/10;
      }
      return sum;
    }
}