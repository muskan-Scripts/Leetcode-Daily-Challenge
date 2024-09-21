class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> li= new ArrayList();
        String si[]=new String[n];
        for(int i=1; i<=n; i++){
            si[i-1]=Integer.toString(i);
        }
        Arrays.sort(si);
        for(int i=0; i<si.length; i++){
            li.add(Integer.parseInt(si[i]));

        }
        return li;
    }
}
