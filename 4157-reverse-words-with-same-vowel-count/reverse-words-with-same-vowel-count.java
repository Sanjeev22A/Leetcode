class Solution {
    public String reverseWords(String s) {
        String[] arr=s.split(" ");
        int firstCount=vowelCount(arr[0]);
        
        for(int i=1;i<arr.length;i++){
            int v=vowelCount(arr[i]);
            if(v==firstCount){
                arr[i]=new StringBuilder(arr[i]).reverse().toString();
            }
        }
        StringBuilder a=new StringBuilder();
        int i=0;
        for(String b:arr){
            a.append(b);
            if(i<arr.length-1){
                a.append(" ");
            }
            i++;
            
        }
        return a.toString();
    }
    int vowelCount(String a){
        int count=0;
        for(char c:a.toCharArray()){
            if("aeiou".indexOf(c)!=-1){
                count++;
            }
        }
        return count;
    }
}