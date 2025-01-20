class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer,Pair> map=new HashMap<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                map.put(mat[i][j],new Pair(i,j));
            }
        }
        int k=0;
        for(int a:arr){
            Pair p=map.get(a);
            mat[p.i][p.j]=-mat[p.i][p.j];
            boolean val=check(p,mat);
            if(val==false){
                k++;
                continue;
            }
            else{
                return k;
            }
            
        }
        return -1;

    }
    boolean check(Pair p,int[][] mat){
        int a=checkRowPainted(p.i,mat);
        int b=checkColumnPainted(p.j,mat);
        if(a==-1 && b==-1){
            return false;
        }
        return true;
    }
    int checkRowPainted(int i,int[][] mat){
        
            boolean flag=true;
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]>0){
                    flag=false;
                    break;
                }
            }
            if(flag==true){
                return i;
            }
        
        return -1;
    }
    int checkColumnPainted(int j,int[][] mat){
        
            boolean flag=true;
            for(int i=0;i<mat.length;i++){
                if(mat[i][j]>0){
                    flag=false;
                    break;
                }
            }
            if(flag==true){
                return j;
            }
        
        return -1;
    }
    class Pair{
        int i,j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
}