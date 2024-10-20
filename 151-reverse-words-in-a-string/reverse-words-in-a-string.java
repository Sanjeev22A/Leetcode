class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String[] arr=s.split("\\s+"); 
        String result="";
        for(int i=arr.length-1;i>=0;i--){
           
            //System.out.println(arr[i]);
            
            result+=arr[i];
            if(i!=0){
                result+=" ";
            }
        }
        return result;
    }
}