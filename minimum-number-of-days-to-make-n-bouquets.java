class Solution {
    private boolean check(int[] bloomDay, int days, int boq, int fpb){
        int[] arr= new int[bloomDay.length];
        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i]<=days)arr[i]=1;
        }
        int curr=0;
        int b=0;
        for(int k: arr){
            if(k==1){
                curr++;
            }
            else{
                curr=0;
            }
            if(curr==fpb){
                b++;
                curr=0;
            }
        }
        return b>=boq;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length<(m*k))return -1;
        int s=Integer.MAX_VALUE;
        int e=Integer.MIN_VALUE;
        int ans=-1;
        for(int i: bloomDay){
            if(i<s)s=i;
            if(i>e)e=i;
        }
        while(s<=e){
            int mid=s+((e-s)/2);
            if(check(bloomDay, mid, m, k)==true){
                e=mid-1;
                ans=mid;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
}