class Solution {
    boolean isVowel(char c){
        if(c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
            return true;
        }
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
            return true;
        }
        return false;
    }

    public String sortVowels(String s) {
        char[] arr=s.toCharArray();
        List<Character> vowels=new ArrayList<>();
        for(char c:arr){
            if(isVowel(c)){
                vowels.add(c);
            }
        }
        Collections.sort(vowels);
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(isVowel(arr[i])){
                //System.out.println(arr[i]+":"+vowels.get(j));
                arr[i]=vowels.get(j);
                j++;
            }
        }
        return String.valueOf(arr);
    }
}