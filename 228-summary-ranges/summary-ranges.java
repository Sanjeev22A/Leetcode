class Solution {
    int mark=-10000;
    public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<>();
        int start=mark;
        int end=mark;
        for(int a:nums){
            if(end==mark){
                start=a;
                end=a;
            }else{
                if(a==end+1){
                    end=a;
                }else{
                    if(start==end){
                        res.add(""+start);
                    }else{
                        res.add(start+"->"+end);
                    }
                    
                    start=a;
                    end=a;
                }
            }
        }
        if(start==end && start==mark){
            return res;
        }
        if(start==end){
            res.add(""+start);
        }else{
            res.add(start+"->"+end);
        }
        return res;

    }
}