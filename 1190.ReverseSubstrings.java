class Solution {
    private void rev(char[] arr, int st, int end){
        int s=st+1;
        int e=end-1;
        while(s<e){
            char temp= arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
    }
    public String reverseParentheses(String s) {
        List<Integer> st=new ArrayList();
        List<Integer> end= new ArrayList();
        char[] sarr= s.toCharArray();
        Stack<Integer> sta=new Stack();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                sta.push(i);
            }
            else if(s.charAt(i)==')'){
                st.add(sta.pop());
                end.add(i);
            }
        }

        for(int i=0; i<st.size(); i++){
            int cs= st.get(i);
            int es= end.get(i);

            rev(sarr, cs, es);

        }
        StringBuilder ans=new StringBuilder();
        for(char ci: sarr){
            if(ci!='(' && ci!=')')ans.append(ci);
        }
        return ans.toString();
    }
}
