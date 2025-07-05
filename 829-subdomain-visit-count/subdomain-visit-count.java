class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> countMap=new HashMap<>();
        for(String a:cpdomains){
            String[] arr=a.split(" ");
        
            int rep=Integer.parseInt(arr[0]);
            String[] domains=arr[1].split("\\.");
            
            if(domains.length==2){
                String d1=new String(arr[1]);
                String d2=domains[1];
                countMap.put(d1,countMap.getOrDefault(d1,0)+rep);
                countMap.put(d2,countMap.getOrDefault(d2,0)+rep);
            }else{
                String d1=new String(arr[1]);
                String d2=domains[1]+"."+domains[2];
                String d3=domains[2];
                countMap.put(d1,countMap.getOrDefault(d1,0)+rep);
                countMap.put(d2,countMap.getOrDefault(d2,0)+rep);
                countMap.put(d3,countMap.getOrDefault(d3,0)+rep);
            }
            
        }
        List<String> ans=new ArrayList<>();
        for(Map.Entry<String,Integer> e:countMap.entrySet()){
            ans.add(e.getValue()+" "+e.getKey());
        }
        return ans;
    }
}