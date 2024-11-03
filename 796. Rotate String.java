class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())return false;
        String sf= s.concat(s);
        if(sf.indexOf(goal)==-1)return false;
        return true;

    }
}
