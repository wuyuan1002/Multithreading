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
     *  虚假唤醒：1.在多核处理器下，一个 notify()可能会唤醒多个 wait()的线程，
     *             此时，生产者只生产了一份数据，却可能唤醒了多个消费者
     *           2.若有多个生产者和消费者，消费者消费完后应该是 notify()唤醒生产者才对，
     *             但正在 wait()的线程可能既有生产者又有消费者，被唤醒的线程若恰巧又是
     *             消费者的话它将会继续消费，但此时数据已经被前一个消费者消费了
     *           3.一个线程被唤醒后，另一个新的线程抢在前面把条件改到不满足了，当前线程
     *             应该继续 wait()，但它却继续往下执行了
     */
    public synchronized void set(String name, int age) {
        System.out.println(Thread.currentThread().getName() + " --- 进");
        while (!this.isEmpty) {
            System.out.println(Thread.currentThread().getName() + "阻塞");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        this.age = age;
        this.isEmpty = false;
        System.out.println(Thread.currentThread().getName() + " --- 出：" + this.name + " --- " + this.age);
        this.notify();
    }
    
    public synchronized void get() {
        System.out.println(Thread.currentThread().getName() + " -- 进");
        while (this.isEmpty) {
            System.out.println(Thread.currentThread().getName() + "阻塞");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.isEmpty = true;
        System.out.println(Thread.currentThread().getName() + " -- 出：" + this.name + " --- " + this.age);
        this.notify();
    }
}
