class Solution {
    public int maxScore(int[] nums) {

        Arrays.sort(nums);

        long prefixSum = 0;
        int score = 0;

        // Traverse from largest to smallest
        for (int i = nums.length - 1; i >= 0; i--) {
            prefixSum += nums[i];

            if (prefixSum > 0) {
                score++;
            } else {
                break;
            }
        }

        return score;
    }
}