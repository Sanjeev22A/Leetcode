class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[1]!=b[1]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[1],b[1]);
        });
        int a=-1,b=-1;
        int count=0;
        for(int[] c:intervals){
          
            if(a==-1 && b==-1){
                a=c[1]-1;
                b=c[1];
         
                count+=2;
            }else{
                if(a>=c[0] && a<=c[1]){
                    continue;
                }
                if(a<c[0]){
                    if(b==c[0]){
                        a=c[0];
                        b=c[1];
                    
                    }else{
                        if(b==c[1]-1){
                            continue;
                        }
                        a=c[1]-1;
                       
                      
                    }
                    
                    count++;
                }
                if(b<c[0]){
                    b=c[1];
                  
                    count++;
                }
            }
            int d=a;
            a=Math.min(a,b);
            b=Math.max(d,b);
        }
        return count;
    }
}