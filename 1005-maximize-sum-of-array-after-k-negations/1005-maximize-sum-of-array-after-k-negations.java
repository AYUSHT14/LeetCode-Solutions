class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length && k>0;i++){
            if(nums[i] < 0){
                nums[i] = -nums[i];
                k--;
            }
        }
        int min = nums[0];
        int sum = 0;
        for(int num:nums){
            min = Math.min(min,num);
            sum +=num;
        }
        if(k%2==1){
            sum-=2*min;
        }
        return sum;
    }
}