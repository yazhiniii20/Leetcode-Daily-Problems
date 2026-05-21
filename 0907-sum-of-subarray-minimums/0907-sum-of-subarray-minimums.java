class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = (int)1000000007;
        long sum = 0;
        int n = arr.length;
        int[] NSE = new int[n];
        int[] PSEE = new int[n];
        findNSE(NSE,arr);
        findPSEE(PSEE,arr);
        for(int i=0;i<arr.length;i++){
            int left = i-PSEE[i];
            int right = NSE[i]-i;            
            long contribution =(1L * arr[i] * left * right) % MOD;
            sum = (sum + contribution) % MOD;
        }
        return (int)sum;
    }
    static void findNSE(int[] NSE, int[] arr){
       Stack<Integer>st = new Stack<>();
       for(int i=arr.length-1;i>=0;i--){
        while(!st.isEmpty() && arr[st.peek()] > arr[i]){
            st.pop();
        }
        NSE[i] = (st.empty())?arr.length:st.peek();
        st.push(i);
       }
    }
    static void findPSEE(int[] PSEE,int[] arr){
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
            st.pop();
        }
        PSEE[i] = (st.empty())?-1:st.peek();
        st.push(i);
        }
    }
}