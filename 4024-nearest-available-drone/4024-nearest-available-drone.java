class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int n = drones.length;
        int ind = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int one = drones[i][0];
            int two = drones[i][1];
            int three = drones[i][2];
            int diff = Math.abs(one-target[0])+Math.abs(two-target[1]);
            if(diff<=three && diff<min){
                min = diff;
                ind = i;
            }
        }
        return ind;
    }
}