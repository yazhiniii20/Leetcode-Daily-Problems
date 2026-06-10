class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int removal = 0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        int lastEnd = intervals[0][1];
        for(int start= 1; start < n;start++){
            if(intervals[start][0] < lastEnd){
                removal++;
            }else{
             lastEnd = intervals[start][1];
            }
        }
        return removal;
    }
}