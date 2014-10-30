/**
 * Largest multiprime prime factor calculator.
 * Input: upper limit number
 * Output: largest prime factor of the product of all prime numbers below the given upper limit
 */

package multiprime.factor;
import java.util.Scanner;
import java.math.*;

/**
 * Author - todyerutz@plainintricacy.wordpress.com
 */

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the upper limit to calculate:");
        int input = in.nextInt();
        in.close();
        System.out.println("Largest multiprime prime factor: " + getFact(calc_mp(input)));

    }

    public static long calc_mp(int x){
    //Calculates the multiprime product below the given limit number
        long mp = 1;
        if(x>=2){
            mp*=2;
        }
        for(int i=3; i<=x; i+=2){
            if(primality(i)){
                mp*=i;
            }
        }
        if(mp>=2){
            return mp;
        }
        return 0;
    }

    public static boolean primality(int q) {
    //Checks a given number for prime status
        if (q == 2) {
            return true;
        } else if (q % 2 == 0 && q != 2) {
            return false;
        } else
            for (int i = 3; i < Math.sqrt(q); i += 2) {
                if (q % i == 0) {
                    return false;
                }
            }
        return true;
    }

    public static int getFact(long x){
    //Calculates the largest prime factor of a given number
        int result=0;
        if(x%2==0){
            result=2;
        }
        for(int i=3; i<Math.sqrt(x); i+=2){
            if(x%i==0&&primality(i)){
                if(i>result) {
                    result = i;
                }
            }
        }
        return result;
    }

}
