class Solution {
    
    String doOperationA(String enter,int a){
        StringBuilder temp=new StringBuilder();
        for(int i=0;i<enter.length();i++){
            if(i%2==0){
                temp.append(enter.charAt(i));
            }else{
                int b=enter.charAt(i)-'0';
                b=b+a;
                b=b%10;
                temp.append(""+b);
            }
        }
        return temp.toString();
    }
    String doOperationB(String enter,int b){ 
        StringBuilder temp=new StringBuilder(); 
        for(int i=0;i<enter.length();i++){ 
            int idx=(i+b)%enter.length(); 
            temp.append(enter.charAt(idx)); 
        } 
        return temp.toString(); 
    }

    Set<String> cache;
    String minimum;
    void doOps(String s,int a,int b,boolean flag){
        if(cache.contains(s+":"+flag)){
            return;
        }
        String op1;
        if(flag){
            op1=doOperationA(s,a);
        }else{
            op1=doOperationB(s,b);
        }
        if(op1.compareTo(minimum)<0){
            minimum=new String(op1);
        }
        //System.out.println(op1);
        cache.add(s+":"+flag);
        doOps(op1,a,b,false);
        doOps(op1,a,b,true);
        
    }
    public String findLexSmallestString(String s, int a, int b) {
        minimum=new String(s);
        cache=new HashSet<>();
        doOps(s,a,b,true);
        doOps(s,a,b,false);
        return minimum;
    }
}