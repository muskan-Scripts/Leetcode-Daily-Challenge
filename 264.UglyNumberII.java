class Solution {
    public int nthUglyNumber(int n) {
        int cnt=1;
        Long currentug=1L;
        PriorityQueue<Long> pq= new PriorityQueue<>();

        while(cnt!=n){
            pq.add(currentug*2L);
            pq.add(currentug*3L);
            pq.add(currentug*5L);

            while(pq.peek()<=currentug){
                pq.poll();
            }
            cnt++;
            currentug=pq.poll();
        }

        return currentug.intValue();
    }
}
