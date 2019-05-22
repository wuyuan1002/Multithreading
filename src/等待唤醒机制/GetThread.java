package 等待唤醒机制;

/**
 * @author wuyuan
 * @version 1.0
 * @date 2019/3/16 20:22
 */
public class GetThread implements Runnable {
    private Student student;

    public GetThread(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        for (int j = 0; j < 20; j++) {
            this.student.get();
        }
    }
}
