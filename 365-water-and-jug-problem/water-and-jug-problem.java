class Solution {
    Set<Integer> seen;
    boolean dfs(int x,int y,int target,int tot){
        if(tot==target){
            return true;
        }
        if(seen.contains(tot) || tot<0 || tot>x+y){
            return false;
        }
        seen.add(tot);
        return dfs(x,y,target,tot-x) || dfs(x,y,target,tot-y) || dfs(x,y,target,tot+x) || dfs(x,y,target,tot+y);
    }
    public boolean canMeasureWater(int x, int y, int target) {
        
        seen=new HashSet<>();
        if(x+y<target){
            return false;
        }
        return dfs(x,y,target,0);
    }
}