import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

class Cache {

    private static Cache cache = null;
    public Map<BigInteger,BigInteger> cachem = new HashMap<>();

    public static Cache getInstance()
    {
        if (cache == null)
            cache = new Cache();
  
        return cache;
    }

    
}
class Fib {
    Cache c;
    
    public Fib(Cache c) {
        this.c = c;
    }

    int doMath(int n) {
        if (n<2) {
            return n;
        }
        return doMath(n-2) + doMath(n-1);
    }
}
class Fib2 {
    BigInteger doMath(BigInteger n, Map<BigInteger, BigInteger> mp) {

        if (mp.containsKey(n)) {
            return mp.get(n);
        }
        int cv = n.compareTo(BigInteger.valueOf(3));
        if (cv < 0) {
            return BigInteger.valueOf(1);
        }
        mp.put(n, doMath(n.subtract(BigInteger.valueOf(2)), mp).add(doMath(n.subtract(BigInteger.valueOf(1)), mp)));
        return mp.get(n);
    }
}

class MyThread1 extends Thread {
    Fib fib;

    MyThread1(Fib f) {
         fib = f;
    }
    @Override
    public void run() {
        synchronized (fib) {
            System.out.println(fib.doMath(34));
        }
    }
}
class YourThread2 extends Thread {
    Fib fib;

    YourThread2(Fib f) {
        fib = f;
    }
    @Override
    public void run() {
        synchronized (fib) {
            System.out.println(fib.doMath(28));
        }
    }
}

public class FibSync {

    public static void main(String[] args) {
        System.out.println("==Application Started==");
        Fib fb = new Fib();
        MyThread1 mRef = new MyThread1(fb);
        YourThread2 yT = new YourThread2(fb);
        mRef.start();
        yT.start();
        System.out.println("==Application Ended==");
    }
}
