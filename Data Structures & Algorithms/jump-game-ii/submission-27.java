class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        if(nums[0] >= nums.length-1) {
            return 1;
        }
        int jumps = 1;
        for(Integer i=0;;) {
            i = findNextBestIndexUsing(i, nums);
            jumps++;
            if(i+nums[i] >= nums.length-1) {
               break;
            }
        }
        return jumps;
    }

    private Integer findNextBestIndexUsing(int i, int[] nums) {
        int bestIndex = i+1;
        for(int j=bestIndex+1; j<=i+nums[i]; j++) {
            if(j+nums[j] >= bestIndex+nums[bestIndex]) {
                bestIndex = j;
            }
        }
        return bestIndex;
    }
}
