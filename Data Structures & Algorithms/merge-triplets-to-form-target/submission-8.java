class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        var result = new int[3];
        for(int i=0; i<triplets.length; i++) {
            if(triplets[i][2] <= target[2] && 
                triplets[i][1] <= target[1] &&
                triplets[i][0] <= target[0]) {
                result[0] = Math.max(result[0], triplets[i][0]);
            result[1] = Math.max(result[1], triplets[i][1]);
            result[2] = Math.max(result[2], triplets[i][2]);
            }
        }
        return Arrays.equals(target, result);
    }
}
