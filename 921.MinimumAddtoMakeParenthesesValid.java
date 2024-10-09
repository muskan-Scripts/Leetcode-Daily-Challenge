class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st= new Stack<>();
        int ins=0;
        for(char curr: s.toCharArray()){
            if(curr=='('){
                st.push('(');
            }
            else{
                if(st.size()==0){
                    ins++;
                }
                else{
                    st.pop();
                }
            }
        }
        ins+= st.size();
        return ins;
    }
}
