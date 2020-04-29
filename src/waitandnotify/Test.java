package waitandnotify;

/**
 * 1. 当前线程必须获得锁，才可以调用该锁的 wait()和 notify()方法，否则会抛出 IllegalMonitorStateException异常
 * 2. 一个 wait()的线程如果被中断会报 InterruptedException异常
 * 3. 一个线程只能被启动一次，否则会抛出 IllegalMonitorStateException异常
 *
 * @author wuyuan
 * @date 2019/3/16
 */
public class Test {
    /**
     * 这个示例是有问题的！！
     * 若只有两个线程时没问题，但是若线程多时，会出现所有线程全部阻塞的情况，死锁了
     */
    public static void main(String[] args) {
        Student student = new Student();
        
        SetThread setThread = new SetThread(student);
        GetThread getThread = new GetThread(student);
        
        new Thread(setThread,"set1").start();
        new Thread(getThread,"get1").start();
        
        // new Thread(setThread,"set2").start();
        // new Thread(getThread,"get2").start();
    }
    
}
