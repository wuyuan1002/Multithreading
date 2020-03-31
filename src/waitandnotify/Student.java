package waitandnotify;

/**
 * 公共资源类，钥匙类
 *
 * @author wuyuan
 * @version 1.0
 * @date 2019/3/16 19:48
 */

public class Student {
    private String name;
    private int age;
    private boolean b;
    
    public Student() {
        this.b = false;
    }
    
    public synchronized void set(String name, int age) {
        if (this.b) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        this.age = age;
        this.b = true;
        this.notify();
    }
    
    public synchronized void get() {
        if (!this.b) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name + "-------" + this.age);
        this.b = false;
        this.notify();
    }
}
