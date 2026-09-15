class Solution {

    public boolean possible(long k, int[] nums, int check) {
        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += k / nums[i];

            if (sum >= check) return true;
        }

        return false;
    }

    public long minimumTime(int[] time, int totalTrips) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < time.length; i++) {
            min = Math.min(min, time[i]);
        }

        long l = 1;
        long r = (long) min * totalTrips;

        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (possible(mid, time, totalTrips)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}