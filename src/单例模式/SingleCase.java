package 单例模式;

/**
 * @author wuyuan
 * @version 1.0
 * @className: SingleCase
 * @description 描述:单例模式
 * @date 2019/4/21
 */
public class SingleCase {
    public static void main(String[] args) {

    }
}



/**
 * 饿汉式
 *
 * 多线程情况下不存在线程安全问题，因为在getSingle1()方法中虽然有共享数据，但对共享数据的操作只有一句，
 * 不会出现线程安全问题。而且，共享数据已经被final修饰，不可修改，更没有安全隐患了。
 */
class Single1{
    private static final Single1 S = new Single1();
    private Single1() {

    }
    public static Single1 getSingle1() {
        return S;
    }
}




/**
 * 懒汉式
 *
 * 在多线程环境下存在线程安全问题，因为getSingle2()中有共享数据且有多条语句操作共享数据，
 * 所以会出现安全问题，会new出多个Single2对象。
 */
class Single2{
    private static Single2 s = null;
    private Single2() {

    }
    public static Single2 getSingle2() {
        if (s == null) {
            s = new Single2();
        }
        return s;
    }
}




/**
 * 加锁后的懒汉式
 *
 * 解决了线程安全问题，但是加锁后每次访问时都要判断锁，效率低
 *
 * 加同步虽然解决了线程安全问题，却降低了效率
 */
class Single3{
    private static Single3 s = null;
    private Single3() {

    }

    /*
     * 同步函数的锁一般是this对象，但这是静态方法，它在对象之前加载，
     * 它没有this指向，用的锁是当前类的字节码文件-->Single3.class
     */

    public static synchronized Single3 getSingle3() {
        if (s == null) {
            s = new Single3();
        }
        return s;
    }
}




/**
 * 解决安全问题和效率问题后的懒汉式
 *
 * 加锁后每一次线程访问都需要判断锁，效率低下，所以我们可以在锁之前再加一个判断，
 * 这样的话只在第一次创建时判断锁，之后都不用再判断锁
 */
class Single4{
    private static Single4 s = null;
    private Single4() {

    }
    public static Single4 getSingle4() {
        //多加了一次判断，只有第一次为空时才会进入判断锁，之后再访问时直接return，解决了效率问题
        if (s == null) {
            //静态方法随着类的加载而加载，所以没有this没有对象，锁对象是类的字节码文件。加锁后可以防止线程多次new对象的线程安全问题。
            synchronized (Single4.class) {
                if (s == null) {
                    s = new Single4();
                }
            }
        }
        return s;
    }
}