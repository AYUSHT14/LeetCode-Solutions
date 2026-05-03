class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        int target = nums.length - 1;
        for(int i=0;i<nums.length;i++){
            if(i > maxJump) return false;
            maxJump = Math.max(maxJump,i+nums[i]);
            if(maxJump>=target) return true;
        }
        return true;
    }
}