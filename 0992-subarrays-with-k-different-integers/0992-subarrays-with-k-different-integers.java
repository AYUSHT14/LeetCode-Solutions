class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k) - atMost(nums,k-1);
    }
    private int atMost(int[] nums,int k){
        if(k == 0) return 0;
        int left = 0;
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int right = 0 ;right < nums.length; right++){
            map.put(nums[right],map.getOrDefault(nums[right],0) + 1);
            while(map.size() > k){
                int leftDigit = nums[left];
                map.put(leftDigit,map.get(leftDigit)-1);
                if(map.get(leftDigit) == 0) map.remove(leftDigit);
                left++;
            }
            res+=right-left+1;
        }
        return res;
    }
}