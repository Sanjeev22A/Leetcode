class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int i=0,j=skill.length-1;
        long count=0;
        int skillTotal=0;
        while(i<j){
            if(i==0){
                skillTotal=skill[i]+skill[j];
            }
            else{
                if(skillTotal!=(skill[i]+skill[j])){
                    return -1L;
                }
            }
            count+=(skill[i]*skill[j]);
            i++;
            j--;
        }
        return count;
    }
}