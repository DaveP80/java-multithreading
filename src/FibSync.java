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

// class MyThread1 extends Thread {
//     Fib fib;

//     MyThread1(Fib f) {
//          fib = f;
//     }
//     @Override
//     public void run() {
//         synchronized (fib) {
//             System.out.println(fib.doMath(34));
//         }
//     }
// }
// class YourThread2 extends Thread {
//     Fib fib;

//     YourThread2(Fib f) {
//         fib = f;
//     }
//     @Override
//     public void run() {
//         synchronized (fib) {
//             System.out.println(fib.doMath(28));
//         }
//     }
// }

public class FibSync {

    public static void main(String[] args) {
        System.out.println("==Application Started==");
        ///Fib fb = new Fib();
        //MyThread1 mRef = new MyThread1(fb);
        //YourThread2 yT = new YourThread2(fb);
        //mRef.start();
        //yT.start();
        System.out.println("==Application Ended==");
    }
}
