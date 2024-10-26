class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result=new ArrayList<>();
        for(String e:folder){
            boolean flag=false;
            for(String re:result){
                if(e.startsWith(re+"/") ){
                    flag=true;
                }
            }
            if(!flag){
                result.add(e);
            }
        }
        return result;
    }
}