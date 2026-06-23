class Solution {
    int getParent(int a){
        return a/2;
    }
    //Returns the depth if b is child of a, else -1
    int isChild(int a,int b){
        
        int c=getParent(b);
        if(b==a){
            return 1;
        }else if(b<a){
           
            return -1;
        }else{
            int d=isChild(a,c);
            if(d==-1){
               
                return -1;
            }
            
            return 1+d;
        }
    }

    int getCycleLength(int a,int b){
        
        //System.out.println(a+":"+b+":"+isChild(a,b));
        if(a>b){
            return getCycleLength(b,a);
        }else if(a==b){
            return 0;
        }
        int c=isChild(a,b);
        if(c!=-1){
         
            return c;
        }else{
            int d=1+getCycleLength(getParent(a),b);
           
            return d;
        }
    }
    public int[] cycleLengthQueries(int n, int[][] queries) {

        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int[] a=queries[i];
            ans[i]=getCycleLength(a[0],a[1]);
           // System.out.println("==========");
        }
        return ans;
    }
}