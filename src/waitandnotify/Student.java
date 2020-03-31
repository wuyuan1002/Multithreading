package waitandnotify;

/**
 * 公共资源类 -- 钥匙类
 *
 * @author wuyuan
 * @date 2019/3/16
 */

public class Student {
    private String name;
    private int age;
    private boolean isEmpty;
    
    public Student() {
        this.isEmpty = true;
    }
    
    /**
     * wait()方法的调用因该写在循环中，防止虚假唤醒
     *
     *  虚假唤醒：1.在多核处理器下，一个 notify()可能会唤醒多个 wait()的线程
     *           2.一个线程唤醒了之后，另一个线程抢在前面把条件改到不满足了
     */
    public synchronized void set(String name, int age) {
        while (!this.isEmpty) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        this.age = age;
        this.isEmpty = false;
        this.notify();
    }
    
    public synchronized void get() {
        // wait()方法的调用因该写在循环中，防止虚假唤醒
        while (this.isEmpty) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name + "-------" + this.age);
        this.isEmpty = true;
        this.notify();
    }
}
