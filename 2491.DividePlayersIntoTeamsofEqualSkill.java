class Solution {
    public long dividePlayers(int[] skill) {
       long ans=0;
       if(skill.length%2!=0)return -1;
       int[] sorcnt=new int[1001];
       for(int curr: skill){
        sorcnt[curr]++;
       } 
       int skp=0;
       for(int i=1; i<=1000; i++){
        while(sorcnt[i]-- >0)skill[skp++]=i;
       }

       int st=0;
       int end=skill.length-1;
       ans=ans + (long)(skill[st]*skill[end]);
        int match=(skill[st]+skill[end]);
        st++;
        end--;
        while(st<end){
            if((skill[st]+skill[end])!=match){
                return -1;
            }
            ans=ans + (long)(skill[st]*skill[end]);
            st++;
            end--;
        }
        return ans;
    }
}
