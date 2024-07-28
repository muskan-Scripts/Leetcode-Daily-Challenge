class Solution {
    private boolean ispalin(String s){
        int st=0;
        int end=s.length()-1;
        while(st<end){
            if(s.charAt(st)==s.charAt(end)){
                st++;
                end--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    private void parthelper(String s, List<String> step, List<List<String>> result){
        if(s==null || s.length()==0){
            result.add(new ArrayList<>(step));
            return;
        }
        for(int i=1; i<=s.length(); i++){
            String temp=s.substring(0,i);
            if(!ispalin(temp))continue;

            step.add(temp);
            parthelper(s.substring(i, s.length()), step, result);
            step.remove(step.size()-1);
        }

        return;
    }
    public List<List<String>> partition(String s) {
        if(s==null || s.length()==0){
            return new ArrayList<>();
        }

        List<List<String>> ans= new ArrayList();

        parthelper(s, new ArrayList<>(), ans);
        return ans;
    }
}
