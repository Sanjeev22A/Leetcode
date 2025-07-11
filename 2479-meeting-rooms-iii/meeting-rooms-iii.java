class Meeting{
    int totalTime,endTime,roomNumber;
    Meeting(int totalTime,int endTime,int roomNumber){
        this.totalTime=totalTime;
        this.endTime=endTime;
        this.roomNumber=roomNumber;
    }
}
class Solution {
    int checkIfFreeRoom(int n,boolean[] isOccupied){
        for(int i=1;i<=n;i++){
            if(!isOccupied[i]){
                return i;
            }
        }
        return -1;
    }
    public int mostBooked(int n, int[][] meetings) {
        int[] used=new int[n+1];
        Arrays.sort(meetings,(a,b)->(a[0]-b[0]));
        PriorityQueue<Meeting> pq=new PriorityQueue<>((a,b)->{
            if(a.endTime!=b.endTime){
                return a.endTime-b.endTime;
            }else{
                return a.roomNumber-b.roomNumber;
            }
        });
        boolean[] isOccupied=new boolean[n+1];
        for(int[] a:meetings){
            int startTime=a[0];
            int endTime=a[1];
            int totalTime=endTime-startTime;
            
            while(true){
                Meeting cur=pq.peek();
                if(cur==null){
                    break;
                }
                if(cur.endTime<=startTime){
                    pq.poll();
                    isOccupied[cur.roomNumber]=false;
                }else{
                    break;
                }
            }
            int room=checkIfFreeRoom(n,isOccupied);
            if(room==-1){
                Meeting prevMeeting=pq.poll();
                endTime=prevMeeting.endTime+totalTime;
                Meeting curMeeting=new Meeting(totalTime,endTime,prevMeeting.roomNumber);
                pq.offer(curMeeting);
                used[prevMeeting.roomNumber]++;
            }else{
                used[room]++;
                isOccupied[room]=true;
                Meeting curMeeting=new Meeting(totalTime,endTime,room);
                pq.offer(curMeeting);
            }
        }
        int maxRoom=0,roomCount=0;
        for(int i=1;i<=n;i++){
            
            if(roomCount<used[i]){
                roomCount=used[i];
                maxRoom=i;

            }
        }
        return maxRoom-1;
    }
}