class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix[0].length;
        int[] height = new int[m];
        int maxArea = 0;
        for(char row[] : matrix){
            for(int i=0;i<m;i++){
                if(row[i] == '1') height[i]++;
                else height[i] = 0;
            }
           maxArea = Math.max(maxArea,largestRectangleArea(height));
        }
        return maxArea;
    }
     static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] PSE = new int[n];
        findPSE(heights,n,PSE);
        int[] NSE = new int[n];
        findNSE(heights,n,NSE);
        int area=0;
        int maxArea = 0;
        for(int i=0;i<n;i++){
         int width = NSE[i]-PSE[i]-1;
         area = heights[i]*width;
         maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
    static void findPSE(int[] heights,int n,int[] PSE){
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            PSE[i] = (st.empty())?-1:st.peek();
            st.push(i);
        }
    }
    static void findNSE(int[] heights,int n,int[] NSE){
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
             while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                st.pop();
            }
            NSE[i] = (st.empty())?n:st.peek();
            st.push(i);
        }
    }
}