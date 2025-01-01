/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long low=1,high=n;
        while(low<=high){
            long mid=(low+high)/2;
            int result=guess((int)mid);
            if(result==0){
                return (int)mid;
            }
            else if(result<0){
                high=mid-1;
            }
            else if(result>0){
                low=mid+1;
            }
        }
        return -1;
    }
}