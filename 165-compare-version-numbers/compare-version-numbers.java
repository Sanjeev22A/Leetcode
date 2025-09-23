class Solution {
    public int compareVersion(String version1, String version2) {
        String[] a=version1.split("\\.");
        String[] b=version2.split("\\.");
        
        for(int i=0;i<Math.max(a.length,b.length);i++){
            int t1=0;
            if(i<a.length){
                t1=Integer.parseInt(a[i]);
            }
            int t2=0;
            if(i<b.length){
                t2=Integer.parseInt(b[i]);
            }
            
            int v=Integer.compare(t1,t2);
            
            if(v!=0){
                return v;
            }
        }
        return 0;
    }
}