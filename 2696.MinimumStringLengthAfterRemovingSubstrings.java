class Solution {
    public int minLength(String s) {
        Stack<Character> st= new Stack();
        for(char curr: s.toCharArray()){
            if(curr=='B'){
                if(!st.empty() && st.peek()=='A'){
                    st.pop();
                }
                else{
                    st.push(curr);
                }
            }
            else if(curr=='D'){
                if(!st.empty() && st.peek()=='C'){
                    st.pop();
                }
                else{
                    st.push(curr);
                }
            }
            else{
                st.push(curr);
            }
        }
        return st.size();
    }
}
