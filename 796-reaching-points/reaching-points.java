class Solution {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(tx<0 || ty<0 || tx<sx || ty<sy){
            return false;
        }
       
        if(sx==tx && sy==ty){
            return true;
        }
        
        if(tx>ty){
            int k=(tx-sx)/ty;
            if(k==0){
                k=1;
            }
           
            return reachingPoints(sx,sy,tx-k*ty,ty);
        }else if(ty>tx){
            int k=(ty-sy)/tx;
            if(k==0){
                k=1;
            }
            
            return reachingPoints(sx,sy,tx,ty-k*tx);
        }else{
            return false;
        }
    }
}