class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> broken=new HashSet<>();
        for(char c:brokenLetters.toCharArray()){
            broken.add(c);
        }
        int count=0;
        String[] arr=text.split(" ");
        for(String a:arr){
            boolean flag=true;
            for(char c:a.toCharArray()){
                if(broken.contains(c)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                count++;
            }
        }
        return count;
    }
}