class Solution {
    public int findCenter(int[][] arr) {
      
        int af=1;
        int bf=1;
        int a=arr[0][0];
        int b=arr[0][1];

        if(arr[1][0]==a || arr[1][1]==a){
            af++;
            
        }
        else if(arr[1][0]==b || arr[1][1]==b){
            bf++;
        }
        return (af>bf)?a:b;
    }
}
