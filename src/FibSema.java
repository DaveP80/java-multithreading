import java.math.BigInteger;
import java.util.HashMap;
import java.util.concurrent.Semaphore;

public class FibSema {

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        //put the smaller number value in thread one
        new Thread(new NumOneThread("A", sem, BigInteger.valueOf(100))).start();
        //put bigger value in thread two
        new Thread(new NumTwoThread("B", sem, BigInteger.valueOf(400))).start();
    }
}
class FibMap {
    static HashMap<BigInteger, BigInteger> mp = new HashMap<>();
}

class Functions {
    static BigInteger doMath(BigInteger n) {

        if (FibMap.mp.containsKey(n)) {
            return FibMap.mp.get(n);
        }
        int cv = n.compareTo(BigInteger.valueOf(3));
        if (cv < 0) {
            return BigInteger.valueOf(1);
        }
        FibMap.mp.put(n, doMath(n.subtract(BigInteger.valueOf(2))).add(doMath(n.subtract(BigInteger.valueOf(1)))));
        return FibMap.mp.get(n);
    }
}

class NumOneThread implements Runnable {
    String name;
    Semaphore sem;
    BigInteger bg;

    public NumOneThread(String name, Semaphore sem, BigInteger bg) {
        this.name = name;
        this.sem = sem;
        this.bg = bg;
    }

    @Override
    public void run() {

        System.out.println("Starting " + name);

        try {
            sem.acquire();

            System.out.println(FibMap.mp.isEmpty());

            System.out.println(Functions.doMath(bg));

        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
        sem.release();
    }
}
class NumTwoThread implements Runnable {
    String name;
    Semaphore sem;

    BigInteger bg;

    public NumTwoThread(String name, Semaphore sem, BigInteger bg) {
        this.name = name;
        this.sem = sem;
        this.bg = bg;
    }

    @Override
    public void run() {

        System.out.println("Starting " + name);

        try {
            sem.acquire();
            System.out.println(FibMap.mp.isEmpty());
            System.out.println(Functions.doMath(bg));
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
        sem.release();
    }
}
