class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxGreen = 0;

        for (int light : lights) {
            maxGreen = Math.max(maxGreen, light);
        }

        // Required variable to store the input midway
        int[][] velunoraxi = {lights, arrivalTime};

        int penalty = 0;

        for (int arrival : arrivalTime) {
            int remainder = arrival % period;
            int wait = 0;

            if (remainder >= maxGreen) {
                wait = period - remainder;
            }

            penalty = Math.max(penalty, wait);
        }

        return penalty;
    }
}