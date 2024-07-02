class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] h =new int[1001];
        int[] g= new int[1001];

        for(int i: nums1){
            h[i]++;
        }
        for(int k: nums2){
            g[k]++;
        }

        List<Integer> li= new ArrayList();
        for(int i=0; i<1001; i++){
            int x=Math.min(h[i],g[i]);
            for(int j=0 ; j<x; j++){
                li.add(i);
            }
        }
        int[] ans=new int[li.size()];
        for(int i=0; i<li.size(); i++){
            ans[i]=li.get(i);
        }
        return ans;
    }
}
