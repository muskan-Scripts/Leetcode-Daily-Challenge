class Solution {
    public int passThePillow(int n, int time) {
        int ini=1;
        int dir=1;

        for(int i=1; i<=time; i++){
            ini=ini+dir;
            if(ini==n){
                dir=-1;
            }
            if(ini==1){
                dir=1;
            }
        }
        return ini;
    }
}
