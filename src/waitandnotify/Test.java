package waitandnotify;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
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
