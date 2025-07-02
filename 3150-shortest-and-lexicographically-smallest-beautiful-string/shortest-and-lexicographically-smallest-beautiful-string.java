class Solution {
    String min(String s1,String s2){
        if(s1.compareTo(s2)<0){
            return s1;
        }
        return s2;
    }
    String removeLeadingAndTrailingZeros(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start <= end && s.charAt(start) == '0') {
            start++;
        }
        while (end >= start && s.charAt(end) == '0') {
            end--;
        }

        return (start <= end) ? s.substring(start, end + 1) : "";
    }

    public String shortestBeautifulSubstring(String s, int k) {
        s=removeLeadingAndTrailingZeros(s);
        //System.out.println(s);
        int i=0,j=0,n=s.length(),count=0;
        char[] c=s.toCharArray();
        String ans=s;
        boolean flag=false;
        while(j<n){
            if(c[j]=='1'){
                count++;
            }
            while(count>k && i<=j){
                flag=true;
                if(c[i]=='1'){
                    count--;
                }
                i++;
            }
            while(count==k){
                flag=true;
                System.out.println(s.substring(i,j+1)+":"+count);
                if((j-i+1)<ans.length()){
                    ans=s.substring(i,j+1);
                }else if((j-i+1)==ans.length()){
                    ans=min(s.substring(i,j+1),ans);
                }
                if(c[i]=='1'){
                    count--;
                }
                i++;
                
            }
            j++;



        }
        if(!flag){
            return "";

        }
        while(i<j){
            
         
            
            if(count==k){
                System.out.println(s.substring(i,j)+":"+count);
                if((j-i)<ans.length()){
                    ans=s.substring(i,j);
                }else if((j-i)==ans.length()){
                    ans=min(s.substring(i,j),ans);
                }
                
            }
            
            if(c[i]=='1'){
                count--;
            }
                
            i++;
            
            
        }
        return ans;
    }
}