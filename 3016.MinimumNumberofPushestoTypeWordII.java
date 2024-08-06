class Solution {
    public int minimumPushes(String word) {
        int[] cnt= new int[26];

        for(char ch: word.toCharArray()){
            cnt[ch-'a']++;
        }
        Arrays.sort(cnt);
        int curr=0;
        int c=1;
        int ans=0;
        for(int i=25; i>=0 && cnt[i]>0 ; i--){
            ans=ans+cnt[i]*c;
            curr++;
            if(curr%8==0){
                c++;
            }
        }

        return ans;

    }
}
