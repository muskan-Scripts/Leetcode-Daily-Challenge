class Solution {
    public boolean isCircularSentence(String sentence) {
       String arr[]=sentence.split(" ");
       if(arr.length>0 && (arr[0].charAt(0)!=(arr[arr.length-1].charAt(arr[arr.length-1].length()-1)))){
        return false;
       }
       for(int i=0; i<arr.length; i++){
        
        if(i>0){
            String curr=arr[i];
            String prev=arr[i-1];
            if(curr.charAt(0)!=prev.charAt(prev.length()-1))return false;
        }
       }
       return true;
    }
}
