package waitandnotify;

/**
 * @author wuyuan
 * @date 2019/3/16
 */
public class GetThread implements Runnable {
    private Student student;
    
    public GetThread(Student student) {
        this.student = student;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            this.student.get();
        }
    }
}
