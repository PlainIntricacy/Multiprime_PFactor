/**
 * Largest multiprime prime factor calculator.
 *
 * Input: upper limit number
 * Output: largest prime factor of the sum of all prime numbers below the given upper limit
 * Also displays the above mentioned prime sum for accuracy checking
 */

package multiprime.factor;
import java.util.Scanner;

/**
 * Author - todyerutz@plainintricacy.wordpress.com
 */

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the upper limit to calculate:");
        int input = in.nextInt();
        in.close();
        System.out.println("Sum of primes below " + input + ": " + calc_mp(input));
        System.out.println("Largest prime factor of " + calc_mp(input) + ": " + getFact(calc_mp(input)));

    }

    public static int calc_mp(int x){
    //Calculates the sum of all primes below the given limit number
        int mp = 0;
        if(x>=2){
            mp+=2;
        }
        for(int i=3; i<=x; i+=2){
            if(primality(i)){
                mp+=i;
            }
        }
        return mp;
    }

    public static boolean primality(int q) {
    //Checks a given number for prime status
        if (q == 2) {
            return true;
        } else if (q % 2 == 0 && q != 2) {
            return false;
        } else {
            for (int i = 3; i <= Math.sqrt(q); i += 2) {
                if (q % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int getFact(int x){
    //Calculates the largest prime factor of a given number
        if(primality(x)){
            System.out.println("The multiprime sum, " + x + ", is itself a prime number.");
            return 0;
        }else {
            int result = 0;
            if(x%2==0){
                result=2;
            }
            for(int i=3; i<=x/2; i+=2){
                if(primality(i)&&x%i==0){
                    result = i;
                }
            }
            return result;
        }
    }

}
