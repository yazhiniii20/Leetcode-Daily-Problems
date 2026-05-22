class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            boolean destroyed = false;
            while(!st.isEmpty() && asteroids[i] < 0 && st.peek() > 0){
                if(st.peek() < -asteroids[i]){
                    st.pop();
                }else if(st.peek() == -asteroids[i]){
                    destroyed = true;
                    st.pop();
                    break;
                }else{
                    destroyed = true;
                    break;
                }               
          }
          if(!destroyed){
          st.push(asteroids[i]);
          }
        }
        int[] ans = new int[st.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i] = st.peek();
            st.pop();
        }
        return ans; 
    }
}