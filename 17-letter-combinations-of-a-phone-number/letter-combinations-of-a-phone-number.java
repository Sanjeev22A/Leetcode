class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> numbers=new HashMap<>();
        numbers.put('2',"abc");
        numbers.put('3',"def");
        numbers.put('4',"ghi");
        numbers.put('5',"jkl");
        numbers.put('6',"mno");
        numbers.put('7',"pqrs");
        numbers.put('8',"tuv");
        numbers.put('9',"wxyz");
        return backTrack(numbers,digits,0,"",new ArrayList<>());
    }
    public static List<String> backTrack(HashMap<Character,String> numbers,String digits,int index,String current,List<String> soln){
        if(index==digits.length()){
            if(index==0){
                return new ArrayList<>();
            }
            soln.add(current);
            
        }
        else{
            char digit=digits.charAt(index);
            String data=numbers.get(digit);
            for(Character c:data.toCharArray()){
                
                backTrack(numbers,digits,index+1,current+c,soln);
            }
        }
        return soln;
    }
}
