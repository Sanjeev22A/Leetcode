class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Set<Integer> suspiciousMethods=new HashSet<>();
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int[] a:invocations){
            if(!map.containsKey(a[0])){
                map.put(a[0],new ArrayList<>());
            }
            map.get(a[0]).add(a[1]);
        }

        //Add all suspicious methods

        Queue<Integer> q=new LinkedList<>();
        q.offer(k);
        while(!q.isEmpty()){
            int top=q.poll();
            if(!suspiciousMethods.contains(top)){
                suspiciousMethods.add(top);
                for(int b:map.getOrDefault(top,new ArrayList<>())){
                    if(!suspiciousMethods.contains(b)){
                        q.offer(b);
                    }
                }
            }
        }

        //Check if Any method outside suspicious method calls it
        boolean flag=false;
        for(int[] a:invocations){
            if(suspiciousMethods.contains(a[1]) && !suspiciousMethods.contains(a[0])){
                flag=true;
                break;
            }
        }

        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!flag && suspiciousMethods.contains(i)){
                continue;
            }
            ans.add(i);
        }
        return ans;
    }
}