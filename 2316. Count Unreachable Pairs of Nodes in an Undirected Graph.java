class Solution {
    private int findp(int x,int[] parent){
        if(x==parent[x])return x;
    
        parent[x]=findp(parent[x], parent);
        return parent[x];
    }
    public long countPairs(int n, int[][] edges) {
        long ans=0;
        int[] parent= new int[n];
        for(int i=0; i<n; i++){
            parent[i]=i;
        }


        for(int[] ed: edges){
            int a=ed[0];
            int b=ed[1];

            int pa=findp(a, parent);
            int pb=findp(b, parent);

            if (pa != pb) {
                parent[pa] = pb; // Union two components
            }
        }
        for (int i = 0; i < n; i++) {
            parent[i] = findp(i, parent);
        }
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0; i<n; i++){
            mp.put(parent[i], mp.getOrDefault(parent[i],0)+1);
        }

        for(Map.Entry<Integer, Integer> e: mp.entrySet()){
            ans+=((long)e.getValue()*((long)n-e.getValue()));
        }
        return ans/2;
        

    }
}
