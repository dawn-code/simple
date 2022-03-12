package com.ctl.simple.main;

/**
 * 验证断点可以改调试多线程模式,控制线程的先后执行，能确保是线程安全模式
 * <p>
 * 1. 不用synchronized的懒汉模式，不用Thread模式断点 输出两个对象地址是不相等的
 * <p>
 * 2. 不用synchronized的懒汉模式，用Thread模式断点 输出两个对象地址是相等的，因为确保了线程的先后顺序
 * <p>
 * 3. 用synchronized的懒汉模式，输出两个对象地址是相等的
 * <p>
 * 结论：synchronized可以使线程安全
 * <p>
 * 注意：如果使用了synchronized关键字，挂起线程就会只有一个不显示其它
 * <p>
 * 参考：https://mp.weixin.qq.com/s?__biz=MzI4OTE2NTk1NQ==&mid=2649580361&idx=1&sn=d5627c7a141aba6480f271174632fef8&chksm=f42a84a5c35d0db3c2f37577dada6af5f0ac8ec2b90859c5adf5d212820d7eaf7ade44299e1e&token=2139939783&lang=zh_CN#rd
 *
 * @author Administrator
 */
public class LazySimpleSingleton {

    private static LazySimpleSingleton simpleSingleton = null;

    private LazySimpleSingleton() {
    }

    /**
     * synchronized注释或者不注释
     *
     * @return
     */
    public static LazySimpleSingleton getInstance() {
        if (null == simpleSingleton) {
            simpleSingleton = new LazySimpleSingleton();
        }
        return simpleSingleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                LazySimpleSingleton t = LazySimpleSingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + ";" + t);
            }).start();
        }
    }


}