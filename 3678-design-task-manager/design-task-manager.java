class Tusks{
    int userId,taskId,priority;
    Tusks(int userId,int taskId,int priority){
        this.userId=userId;
        this.taskId=taskId;
        this.priority=priority;
    }
}
class Point{
    int userId,priority;
    Point(int userId,int priority){
        this.userId=userId;
        this.priority=priority;
    }
}
class TaskManager {
    PriorityQueue<Tusks> pq=new PriorityQueue<>((a,b)->{
        if(a.priority!=b.priority){
            return Integer.compare(b.priority,a.priority);
        }
        return Integer.compare(b.taskId,a.taskId);
    });
    Map<Integer,Point> taskMap;
    public TaskManager(List<List<Integer>> tasks) {
        taskMap=new HashMap<>();
        
        for(List<Integer> a:tasks){
            int taskId=a.get(1);
            int userId=a.get(0);
            int priority=a.get(2);
            this.add(userId,taskId,priority);

        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Tusks t=new Tusks(userId,taskId,priority);
        Point p=new Point(userId,priority);
        taskMap.put(taskId,p);
        pq.offer(t);
    }
    
    public void edit(int taskId, int newPriority) {
        
        Point a=taskMap.get(taskId);
        a.priority=newPriority;
        Tusks t=new Tusks(a.userId,taskId,newPriority);
        pq.offer(t);
        taskMap.put(taskId,a);
    }
    
    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }
    
    public int execTop() {
        while(!pq.isEmpty()){
            Tusks t=pq.poll();
            //System.out.println(t.userId+":"+t.taskId+":"+t.priority);
            if(!taskMap.containsKey(t.taskId)){
                continue;
            }
            Point p=taskMap.get(t.taskId);
            
            if(p.priority==t.priority && t.userId==p.userId){
                taskMap.remove(t.taskId);
                return t.userId;
            }else{
                continue;
            }
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */