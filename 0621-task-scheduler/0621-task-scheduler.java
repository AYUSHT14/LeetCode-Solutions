class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch: tasks){
            freq[ch - 'A']++;
        }
        Arrays.sort(freq);
        int maxFreq = freq[25];
        int countMaxFreq = 1;
        for(int i=24;i>=0;i--){
            if(freq[i] == maxFreq) countMaxFreq++;
            else break;
        }
        return Math.max(tasks.length,(maxFreq-1)*(n+1)+countMaxFreq);
    }
}