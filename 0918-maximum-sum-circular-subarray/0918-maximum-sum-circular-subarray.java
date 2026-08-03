class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int total = nums[0];

        int currentMax = nums[0];
        int maximumSum = nums[0];

        int currentMin = nums[0];
        int minimumSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            total += nums[i];

            // Kadane for maximum subarray
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maximumSum = Math.max(maximumSum, currentMax);

            // Modified Kadane for minimum subarray
            currentMin = Math.min(nums[i], currentMin + nums[i]);
            minimumSum = Math.min(minimumSum, currentMin);
        }

        // If all elements are negative
        if (maximumSum < 0) {
            return maximumSum;
        }

        // Circular maximum subarray
        int circularSum = total - minimumSum;

        return Math.max(maximumSum, circularSum);
    }
}