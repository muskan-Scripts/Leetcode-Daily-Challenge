class Solution {
    public int[] finalPrices(int[] prices) {
        int[] nextsmaller=new int[prices.length];
        Stack<Integer> st=new Stack();
        for(int i=prices.length-1; i>=0; i--){
            while(!st.empty() && st.peek()>prices[i]){
                st.pop();
            }
            if(!st.empty()){
                nextsmaller[i]=st.peek();
            }
            else{
                nextsmaller[i]=-1;
            }

            st.push(prices[i]);
        }

        for(int i=0; i<prices.length; i++){
            if(nextsmaller[i]==-1){
                nextsmaller[i]=prices[i];
            }
            else{
                nextsmaller[i]=prices[i]-nextsmaller[i];
            }
        }
        return nextsmaller;
    }
}
