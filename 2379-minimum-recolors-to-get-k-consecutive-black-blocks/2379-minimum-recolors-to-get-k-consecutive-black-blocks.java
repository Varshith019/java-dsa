class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int min = Integer.MAX_VALUE;
        int wcount = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            if (blocks.charAt(r) == 'W')
                wcount++;

            if (r - l + 1 == k) {
                min = Math.min(min, wcount);
                if (blocks.charAt(l) == 'W')
                    wcount--;
                l++;
            }

        }
        return min;
    }
}