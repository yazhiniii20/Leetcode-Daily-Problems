class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0, right = 0, maxSum = 0, currentSum = 0;
        Set<Integer> set = new HashSet<>();

        while (right < nums.length) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            currentSum += nums[right];
            maxSum = Math.max(maxSum, currentSum);
            right++;
        }
        return maxSum;
    }
}