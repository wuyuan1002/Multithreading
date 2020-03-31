package waitandnotify;

/**
 * @author wuyuan
 * @date 2019/3/16
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
                student.set("wy", 23);
            } else {
                student.set("wyj", 22);
            }
        }
    }
}