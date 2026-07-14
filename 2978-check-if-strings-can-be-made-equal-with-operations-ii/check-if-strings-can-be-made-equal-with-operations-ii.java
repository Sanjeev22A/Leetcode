class Solution {
    boolean checkEqual(char[] a,char[] b){
        if(a==null && b==null){
            return true;
        }
        if((a==null && b!=null)|| (a!=null && b==null)){
            return false;
        }

        if(a.length==b.length){
            Arrays.sort(a);
            Arrays.sort(b);
            for(int i=0;i<a.length;i++){
                if(a[i]!=b[i]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public boolean checkStrings(String s1, String s2) {
        StringBuilder s1Even=new StringBuilder();
        StringBuilder s1Odd=new StringBuilder();
        StringBuilder s2Even = new StringBuilder();
        StringBuilder s2Odd = new StringBuilder();
        for(int i=0;i<s1.length();i++){
            if(i%2==0){
                s1Even.append(s1.charAt(i));
            }else{
                s1Odd.append(s1.charAt(i));
            }
        }
        for(int i=0;i<s2.length();i++){
            if(i%2==0){
                s2Even.append(s2.charAt(i));
            }else{
                s2Odd.append(s2.charAt(i));
            }
        }
        char[] s1OddTemp=s1Odd.toString().toCharArray();
        char[] s1EvenTemp=s1Even.toString().toCharArray();
        char[] s2OddTemp=s2Odd.toString().toCharArray();
        char[] s2EvenTemp=s2Even.toString().toCharArray();
        return checkEqual(s1OddTemp,s2OddTemp)&&checkEqual(s1EvenTemp,s2EvenTemp);
    }
}