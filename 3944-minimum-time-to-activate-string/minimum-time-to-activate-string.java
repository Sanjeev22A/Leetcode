class Solution {
    public int minTime(String s, int[] order, int k) {
        TreeSet<Integer> set=new TreeSet<>();
        Set<Integer> seen=new HashSet<>();
        int len=s.length();
        long total=len*(len+1)/2; //Represents the total substrings
        long invalid=total; //Initially all are invalid
        int i=0;
        for(int a:order){
            if(seen.contains(a)){
                continue;
            }//Dont process same index again
            seen.add(a);
            Integer lower=set.lower(a);
            Integer higher=set.higher(a);
            set.add(a);
            if(lower==null){
                lower=-1;
            }
            if(higher==null){
                higher=len;
            }
            //Initially all substrings from lower+1 to higher-1 were invalid
            //int initInvalidLength=(higher-1)-(lower+1)-1
            long invalidLength=(long)higher-lower-1;
            
            long leftSplit=(long)a-lower-1;
            
            long  rightSplit=(long)higher-a-1;
            //Now the number of invalids have reduced from original to left+right split counts
            long sub=invalidLength*(invalidLength+1)/2-leftSplit*(leftSplit+1)/2-rightSplit*(rightSplit+1)/2;
            invalid-=sub;
            
            if(total-invalid>=(long)k){
                return i;
            }
            i++;
        }
        return -1;
    }
}