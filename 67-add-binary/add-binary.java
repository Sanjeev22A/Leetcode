class Solution {
    public String addBinary(String a, String b) {
        String cur="";
        int i=a.length()-1,j=b.length()-1;
        int prevCarry=0;
        while(i>=0 && j>=0){
            char a1=a.charAt(i);
            char a2=b.charAt(j);
            int val=0;
            if(a1=='1'){
                val++;
            }
            if(a2=='1'){
                val++;
            }
            val+=prevCarry;
            prevCarry=val/2;
            int rem=val%2;
            cur=rem+cur;
            i--;
            j--;
        }
        while(i>=0){
            char a1=a.charAt(i);
            int val=prevCarry;
            if(a1=='1'){
                val++;
            }
            prevCarry=val/2;
            int rem=val%2;
            cur=rem+cur;
            i--;
        }
        while(j>=0){
            char a1=b.charAt(j);
            int val=prevCarry;
            if(a1=='1'){
                val++;
            }
            prevCarry=val/2;
            int rem=val%2;
            cur=rem+cur;
            j--;
        }
        if(prevCarry==1){
            cur=prevCarry+cur;
        }
        return cur;
    }
}