package waitandnotify;

/**
 * @author wuyuan
 * @date 2019/3/16
 */
public class SetThread implements Runnable {
    private Student student;
    
    public SetThread(Student student) {
        this.student = student;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            if (i % 2 == 0) {
                this.student.set("wy", 23);
            } else {
                this.student.set("wyj", 22);
            }
        }
    }
}
