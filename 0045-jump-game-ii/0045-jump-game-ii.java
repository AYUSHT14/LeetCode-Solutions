class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currEnd = 0;
        int fartest = 0;
        for(int i=0;i<nums.length-1;i++){
            fartest = Math.max(fartest,i+nums[i]);
            if(i == currEnd){
                jumps++;
                currEnd = fartest;
            }
        }
        return jumps;
    }
}