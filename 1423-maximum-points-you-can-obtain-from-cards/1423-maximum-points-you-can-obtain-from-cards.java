class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;
        for(int x:cardPoints) total+=x;
        if(k==n) return total;
        int window = n-k;
        int current = 0;
        for(int i=0;i<window;i++){
            current += cardPoints[i];
        }
        int minSum = current;
        for(int i=window;i<n;i++){
            current+=cardPoints[i];
            current-=cardPoints[i-window];
            minSum = Math.min(minSum,current);
        }
        return total - minSum;
    }
}