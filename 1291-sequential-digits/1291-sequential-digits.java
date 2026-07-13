class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        int lowlen = noOfDigits(low);
        int highlen = noOfDigits(high);
        String largest = "123456789";
        for(int len=lowlen; len<=highlen; len++){
           for(int start=0; start<=9-len; start++){
            int num = Integer.parseInt(largest.substring(start,start+len));
            if(num >= low && num <= high){
                ans.add(num);
            }
           }
        }
        return ans;
    }
    static int noOfDigits(int num){
        int count = 0;
        while(num > 0){
            num = num/10;
            count++;
        }
        return count;
    }
}