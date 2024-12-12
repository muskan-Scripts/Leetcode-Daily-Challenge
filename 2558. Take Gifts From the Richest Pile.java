class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>((a, b)->{return b-a;});
        for(int i=0; i<gifts.length; i++){
            pq.add(gifts[i]);
        }

        for(int i=0; i<k; i++){
            int curr= pq.poll();
            int r= (int)Math.sqrt(curr);
            pq.add(r);
        }
        long ans =0;
        for(int i=0; i<gifts.length; i++){
            ans +=pq.poll();
        }
        
        return ans;
    }
}
