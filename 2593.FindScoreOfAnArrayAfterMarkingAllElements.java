class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(b[0]==a[0]){
            return a[1]-b[1];
            }
            return a[0]-b[0];});
    for(int i=0; i<nums.length; i++){
        pq.add(new int[]{nums[i], i});
    }
    boolean vis[]=new boolean[nums.length];
    long score=0;
    while(!pq.isEmpty()){
        int[] curr= pq.poll();
        if(vis[curr[1]]==true)continue;
        score+=(long)curr[0];
        vis[curr[1]]=true;
        if(curr[1]-1>=0 )vis[curr[1]-1]=true;
        if(curr[1]+1<nums.length)vis[curr[1]+1]=true;
    }

return score;
    }
}
