import java.math.BigInteger;

class MyThread2 extends Thread {
    Fib2 fib;
    MyThread2(Fib2 f) {
        fib = f;
    }
    @Override
    public void run() {
        synchronized (fib) {
            System.out.println(fib.doMath(BigInteger.valueOf(80)));
        }

    }
}
class YourThread3 extends Thread {
    Fib fib;
    YourThread3(Fib f) {
        fib = f;
    }
    @Override
    public void run() {
        synchronized(fib) {
            System.out.println(fib.doMath(BigInteger.valueOf(20)));
        }
    }
}
public class FibSync2 {
    //comment out or uncomment the System.time methods to see the time in ms
    public static void main(String[] args) {
        //long startTime = System.currentTimeMillis();

        System.out.println("==Application Started==");
        //HashMap<BigInteger, BigInteger> memo = Cache.getCache();
        Fib2 fb = new Fib2();
        Fib fs = new Fib();
        MyThread2 mRef = new MyThread2(fb);
        YourThread3 yT = new YourThread3(fs);
        yT.start();
        mRef.start();
        //System.out.println(fb.doMath(BigInteger.valueOf(58), new HashMap<>()));
        //System.out.println(fs.doMath(58));
        System.out.println("==Application Ended==");
//        long estimatedTime = System.currentTimeMillis() - startTime;
//        System.out.println(estimatedTime);
    }
}
