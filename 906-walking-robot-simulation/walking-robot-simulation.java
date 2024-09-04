class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int xCoordinate=0,yCoordinate=0;
        int maxDistance=0;
        HashSet<String> obs=new HashSet<>();
        for(int[] ob:obstacles){
            obs.add(ob[0]+","+ob[1]);
        }
        int distance=0;
        int[][] direction={{0,1},{1,0},{0,-1},{-1,0}};
        int cur=0;
        for(int command:commands){
            if(command==-1){
                cur=(cur+1)%4;
            }
            else if(command==-2){
                cur=(cur+3)%4;
            }
            else{
                for(int i=0;i<command;i++){
                    int newxCoordinate=xCoordinate+direction[cur][0];
                    int newyCoordinate=yCoordinate+direction[cur][1];
                    if(!obs.contains(newxCoordinate+","+newyCoordinate)){
                        xCoordinate=newxCoordinate;
                        yCoordinate=newyCoordinate;
                        distance=xCoordinate*xCoordinate+yCoordinate*yCoordinate;
                        if(distance>maxDistance){
                            maxDistance=distance;
                        }
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return maxDistance;
    }
}