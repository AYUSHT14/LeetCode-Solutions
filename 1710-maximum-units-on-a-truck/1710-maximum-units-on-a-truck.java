class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int totalUnits = 0;
        for(int[] box : boxTypes){
            int boxToTake = Math.min(truckSize,box[0]);
            totalUnits+=boxToTake*box[1];
            truckSize -= boxToTake;
            if(truckSize == 0) break;
        }
        return totalUnits;
    }
}