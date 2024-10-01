class Solution {
    public boolean canArrange(int[] arr, int k) {
        int ha[]=new int[k];
        for(int i=0; i<arr.length; i++){
            int r=arr[i]%k;
            if(r<0)r=k+r;
            ha[r]++;
        }
        if(ha[0]%2!=0)return false;
        if(k%2==0 && ha[k/2]%2!=0){
            return false;
        }
        for(int i=1; i<k; i++){
            if(k%2==0 && i==k/2)continue;
            if(ha[i]!=ha[k-i])return false;
        }
        return true;
    }
}
