class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] PGEE = new int[n];
        int[] NGE = new int[n];
        findPGEE(nums,n,PGEE);
        findNGE(nums,n,NGE);
        long max = subarrayMaximums(nums,n,PGEE,NGE);
        int[] PSEE = new int[n];
        int[] NSE = new int[n];
        findPSEE(nums,n,PSEE);
        findNSE(nums,n,NSE);
        long min = subarrayMinimums(nums,n,PSEE,NSE);
        return max-min;      
    }
    static void findPGEE(int[] nums,int n,int[] PGEE){
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
        while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
            st.pop();
        }
        PGEE[i] = (st.empty())?-1:st.peek();
        st.push(i);
      }
    }
    static void findNGE(int[] nums,int n,int[] NGE){
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                st.pop();
            }
            NGE[i] = (st.empty())?n:st.peek();
            st.push(i);
        }
    }
    static long subarrayMaximums(int[] nums,int n,int[] PGEE,int[] NGE){
        long sum = 0;
        for(int i=0;i<n;i++){
            int left = i-PGEE[i];
            int right = NGE[i] - i;
            sum += 1L*nums[i]*left*right;
        }
        return sum;
    }
    static void findPSEE(int[] nums,int n,int[] PSEE){
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
        while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
            st.pop();
        }
        PSEE[i] = (st.empty())?-1:st.peek();
        st.push(i);
      }
    }
    static void findNSE(int[] nums,int n,int[] NSE){
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                st.pop();
            }
            NSE[i] = (st.empty())?n:st.peek();
            st.push(i);
        }
    }
    static long subarrayMinimums(int[] nums,int n,int[] PSEE,int[] NSE){
        long sum = 0;
        for(int i=0;i<n;i++){
            int left = i-PSEE[i];
            int right = NSE[i] - i;
            sum += 1L*nums[i]*left*right;
        }
        return sum;
    }
}