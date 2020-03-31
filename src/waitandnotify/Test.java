package waitandnotify;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 1. 当前线程必须获得锁，才可以调用该锁的 wait()和 notify()方法，否则会抛出 IllegalMonitorStateException异常
 * 2. 一个 wait()的线程如果被中断会报 InterruptedException异常
 *
 * @author wuyuan
 * @date 2019/3/16
 */
public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        SetThread setThread = new SetThread(student);
        GetThread getThread = new GetThread(student);
        
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3));
        pool.execute(setThread);
        pool.execute(getThread);
        pool.shutdown();
    }
    
}
