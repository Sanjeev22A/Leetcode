class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int lan=-1,c=Integer.MAX_VALUE;
        List<Set<Integer>> languageSets=new ArrayList<>();
        for(int[] a:languages){
            Set<Integer> s=new HashSet<>();
            for(int b:a){
                s.add(b);
            }
            languageSets.add(s);
        }
        for(int i=1;i<=n;i++){
            int count=0;
            Set<Integer> people=new HashSet<>();
            for(int[] a:friendships){
                int f1=a[0];
                int f2=a[1];
                boolean intersection=false;
                for(int b:languageSets.get(f1-1)){
                    if(languageSets.get(f2-1).contains(b)){
                        intersection=true;
                        break;
                    }
                }
                if(!intersection){
                    if(!languageSets.get(f1-1).contains(i)){
                        people.add(f1);
                    }
                    if(!languageSets.get(f2-1).contains(i)){
                        people.add(f2);
                    }
                }
            }
            count=people.size();
            if(count<c){
                c=count;
                lan=i;
            }
        }
        return c;
    }
}