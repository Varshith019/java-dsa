class Solution {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;

        // [enqueueTime, processingTime, originalIndex]
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        // Sort by enqueue time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Min Heap:
        // 1. smaller processing time
        // 2. if same, smaller index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[2], b[2]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int[] ans = new int[n];
        int index = 0;
        int i = 0;

        long currentTime = 0;

        while (i < n || !pq.isEmpty()) {

            // CPU idle → jump to next task arrival
            if (pq.isEmpty() && currentTime < arr[i][0]) {
                currentTime = arr[i][0];
            }

            // Add all tasks that have arrived
            while (i < n && arr[i][0] <= currentTime) {
                pq.offer(arr[i]);
                i++;
            }

            // Process best available task
            int[] task = pq.poll();

            ans[index++] = task[2];

            currentTime += task[1];
        }

        return ans;
    }
}