class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=(n*2)-1;i>=0;i--){
            if(i >= n){
              while(!st.isEmpty() && st.peek() <= nums[i%n]){
                st.pop();
              }
              st.push(nums[i%n]);
            }else{
                while(!st.isEmpty() && nums[i] >= st.peek()){
                st.pop();
               }
               if(st.empty()){
                nge[i] = -1;
               }else{
                nge[i] = st.peek();
               }
               st.push(nums[i]);
            }
        }
        return nge;
    }
}