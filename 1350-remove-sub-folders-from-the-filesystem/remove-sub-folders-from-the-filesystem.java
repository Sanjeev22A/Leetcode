class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res=new ArrayList<>();
        boolean[] seen=new boolean[folder.length];
        for(int i=0;i<folder.length;i++){
            if(!seen[i]){
                String cur=folder[i];
                res.add(cur);
                seen[i]=true;
                cur=cur+"/";
                for(int j=i+1;j<folder.length;j++){
                    if(folder[j].startsWith(cur)){
                        seen[j]=true;
                    }
                }
            }
        }
        return res;
        
    }
}