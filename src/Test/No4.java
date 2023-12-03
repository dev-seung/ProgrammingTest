package Test;

import java.math.BigInteger;

public class No4 {
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    public static void main(String[] args) {
        BigInteger result = factorial(1000000);
        System.out.println(result);
    }
}
