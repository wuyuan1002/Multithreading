package 等待唤醒机制;

/**
 * @author wuyuan
 * @version 1.0
 * @date 2019/3/16 20:16
 */
public class SetThread implements Runnable {
    private int i;
    private Student student;
    
    public SetThread(Student student) {
        this.i = 0;
        this.student = student;
    }
    
    @Override
    public void run() {
        for (int j = 0; j < 20; j++, this.i++) {
            if (this.i % 2 == 0) {
                student.set("wuyuan", 23);
            } else {
                student.set("wyj", 22);
            }
        }
    }
}
