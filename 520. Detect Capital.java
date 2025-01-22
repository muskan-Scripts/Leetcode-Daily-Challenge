class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()<2)return true;

        if(word.charAt(0)>='A' && word.charAt(0)<='Z'){
            char[] curr= word.toCharArray();
            boolean flag= curr[1]>='A' && curr[1]<='Z';
            for(int i=2; i<curr.length; i++){
                if((curr[i]>='A' && curr[i]<='Z')!=flag)return false;
            }
        }
        else{
            for(char curr: word.toCharArray()){
                if(curr>='A' && curr<='Z'){
                    return false;
                }
            }
        }

        return true;
    }
}
