class Solution {
    public String removeDuplicateLetters(String s) {
        int last[] = new int[26]; // last me vo character wps aa raha h ki nhi vo check krne k liye h.
        boolean used[] = new boolean[26]; // Preven duplicate in stack.
        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a'] = i;
        }
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(used[ch -'a']) continue;
            while(!st.isEmpty() && st.peek() > ch && last[st.peek()-'a']>i){
                char remove = st.pop();
                used[remove-'a'] = false;
            }
            st.push(ch);
            used[ch-'a'] = true;
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        return str.reverse().toString();
    }
}