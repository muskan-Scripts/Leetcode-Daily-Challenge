class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> licurr=new ArrayList<>();

        for(int i=0; i<expression.length(); i++){
            char curr= expression.charAt(i);
            if(curr=='*' || curr=='+' || curr=='-'){
                List<Integer> li1= diffWaysToCompute(expression.substring(0,i));
                List<Integer> li2 = diffWaysToCompute(expression.substring(i+1, expression.length()));
                for(int a: li1){
                    for(int b: li2){
                        int val=0;
                        if(curr=='*')licurr.add(a*b);
                        else if(curr=='+')licurr.add(a+b);
                        else if(curr=='-')licurr.add(a-b);
                    }
                }

            }
            
        }

        if(licurr.size()==0){
            licurr.add(Integer.parseInt(expression));
        }
        return licurr;
    }
}
