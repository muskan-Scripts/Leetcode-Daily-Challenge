class Solution {
    public boolean check(String si, String sj){
        return sj.contains(si);
    }
    public List<String> stringMatching(String[] words) {
        List<String> ans= new ArrayList<>();
        for(int i=0; i<words.length; i++){
            for(int j=0; j<words.length; j++){
                if(i==j)continue;
                boolean flag= check(words[i], words[j]);
                if(flag){ans.add(words[i]);
                break;}

            }
        }

        return ans;
    }
}
