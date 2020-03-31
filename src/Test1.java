/**
 * @author wuyuan
 * @date 2020/3/30
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        synchronized (object) {
            object.wait();
        }
    }
}
