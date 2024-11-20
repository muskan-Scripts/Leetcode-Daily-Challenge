class Solution {
    public int takeCharacters(String s, int k) {
        // Total counts
        int[] count = new int[3];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        if (Math.min(Math.min(count[0], count[1]), count[2]) < k) {
            return -1;
        }
        
        // Sliding Window
        int res = Integer.MAX_VALUE;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'a']--;
            
            while (Math.min(Math.min(count[0], count[1]), count[2]) < k) {
                count[s.charAt(l) - 'a']++;
                l++;
            }
            res = Math.min(res, s.length() - (r - l + 1));
        }
        return res;
    }
}





// class Solution {
//     public int takeCharacters(String s, int k) {
//         if(k==0)return 0;
//         char[] ca= new char[s.length() * 2];
//         for(int i=s.length(); i<ca.length; i++){
//             ca[i]= s.charAt(i-s.length());
//             ca[i-s.length()]=ca[i];
//         }

//         int a=0;
//         int b=0;
//         int c=0;
//         if(ca[0]=='a')a++;
//         else if(ca[0]=='b')b++;
//         else if(ca[0]=='c')c++;
//         int ans=Integer.MAX_VALUE;
//         for(int i=1; i<ca.length; i++){
//             if(a==k && b==k && c==k){
//                 ans=Math.min(ans, i
                
                
                
                
                
                
                
                
                
                
                
                
                
//                 )
//             }
//         }
//     }
// }
