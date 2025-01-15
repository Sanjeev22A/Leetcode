class Solution {
    private boolean isSet(int num,int bit){
        return (num&(1<<bit))!=0;
    }
    private int setBit(int num,int bit){
        return (num|(1<<bit));
    }
    private int unSetBit(int num,int bit){
        return (num&(~(1<<bit)));
    }
    public int minimizeXor(int num1, int num2) {
        int bit=0;
        
        int num1BitCount=Integer.bitCount(num1);
        int num2BitCount=Integer.bitCount(num2);
        int number=num1;
        while(num1BitCount<num2BitCount){
            if(!isSet(number,bit)){
                number=setBit(number,bit);
                num1BitCount++;
            }
            bit++;
        }
        while(num1BitCount>num2BitCount){
            if(isSet(number,bit)){
                number=unSetBit(number,bit);
                num1BitCount--;
            }
            bit++;
        }
        return number;

    }
}