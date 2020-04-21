package android.stack.staticmodifier;

public class Test {
    public static void main(String[] args) {
        /**
         * 当初始化一个类的时候，如果发现其父类还没有进行过初始化，则需要先触发其父类的初始化。
         * 如果父类已经进行过初始化，则父类的静态变量和静态代码块无需再次执行。
         */
//        new Farther();
//        System.out.println("---------");
        new Son();
    }
}
