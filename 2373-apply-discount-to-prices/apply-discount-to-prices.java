import java.math.BigDecimal;
import java.math.RoundingMode;

class Solution {
    static boolean containsChar(String s){
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                continue;
            }
            return false;
        }
        return true;
    }
    public String discountPrices(String sentence, int discount) {
        String[] arr = sentence.split(" ");
        int i = 0;
        for (String a : arr) {
            if (a.charAt(0) == '$' && containsChar(a)) {
                try {
                    double val = Double.parseDouble(a.substring(1));
                    double discountedPrice = val * (1 - (discount / 100.0));
                    
                    BigDecimal bd = new BigDecimal(discountedPrice).setScale(2, RoundingMode.HALF_UP);
                    arr[i] = "$" + bd.toPlainString(); 
                } catch (NumberFormatException e) {
                    arr[i] = a;
                }
            } else {
                arr[i] = a;
            }
            i++;
        }
        sentence = String.join(" ", arr);
        return sentence;
    }
}
