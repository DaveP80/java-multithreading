import java.math.BigInteger;
import java.util.HashMap;

class Cache {

    private static HashMap<BigInteger, BigInteger> cache;

    public static HashMap<BigInteger, BigInteger> getCache() {

        if (cache == null) {
            synchronized(Cache.class) {
            cache = new HashMap<BigInteger,BigInteger>();
            }
        }
        return cache;
    }
 
}
class Fib {

    HashMap<BigInteger, BigInteger> memo = Cache.getCache();

    BigInteger doMath(BigInteger n) {

        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int cv = n.compareTo(BigInteger.valueOf(3));
        if (cv < 0) {
            return BigInteger.valueOf(1);
        }
        memo.put(n, doMath(n.subtract(BigInteger.valueOf(2))).add(doMath(n.subtract(BigInteger.valueOf(1)))));
        return memo.get(n);
    }
}
class Fib2 {

    HashMap<BigInteger, BigInteger> memo2 = Cache.getCache();

    BigInteger doMath(BigInteger n) {

        if (memo2.containsKey(n)) {
            return memo2.get(n);
        }
        int cv = n.compareTo(BigInteger.valueOf(3));
        if (cv < 0) {
            return BigInteger.valueOf(1);
        }
        memo2.put(n, doMath(n.subtract(BigInteger.valueOf(2))).add(doMath(n.subtract(BigInteger.valueOf(1)))));
        return memo2.get(n);
    }
}

class Fib3 {

    HashMap<BigInteger, BigInteger> memo2 = Cache.getCache();

    BigInteger doMath(BigInteger n) {

        if (memo2.containsKey(n)) {
            return memo2.get(n);
        }
        int cv = n.compareTo(BigInteger.valueOf(3));
        if (cv < 0) {
            return BigInteger.valueOf(1);
        }
        memo2.put(n, doMath(n.subtract(BigInteger.valueOf(2))).add(doMath(n.subtract(BigInteger.valueOf(1)))));
        return memo2.get(n);
    }
}

public class FibSync {
    public static void main(String[] args) {
        System.out.println("==Application Started==");
        System.out.println("==Application Ended==");
    }
}
