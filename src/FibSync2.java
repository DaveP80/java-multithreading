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

class YourThread4 extends Thread {
    Fib3 fib;

    YourThread4(Fib3 f) {
        fib = f;
    }
    @Override
    public void run() {
        synchronized(fib) {
            System.out.println(fib.doMath(BigInteger.valueOf(40)));
        }
    }

}
public class FibSync2 extends Thread {

    //comment out or uncomment the System.time methods to see the time in ms
    public static void main(String[] args) throws InterruptedException {
        //long startTime = System.currentTimeMillis();
        System.out.println("==Application Started==");

        Thread.UncaughtExceptionHandler h = new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread thread, Throwable exception) {

                thread.interrupt();

            }
        };
        Fib2 fb = new Fib2();
        Fib fs = new Fib();
        Fib3 fd = new Fib3();
        MyThread2 mRef = new MyThread2(fb);
        mRef.setUncaughtExceptionHandler(h);
        YourThread3 yT = new YourThread3(fs);
        yT.setUncaughtExceptionHandler(h);
        YourThread4 yF = new YourThread4(fd);
        yF.setUncaughtExceptionHandler(h);
        yT.start();
        mRef.start();
        yF.start();

        System.out.println("==Application Ended==");
//        long estimatedTime = System.currentTimeMillis() - startTime;
//        System.out.println(estimatedTime);
    }
}
