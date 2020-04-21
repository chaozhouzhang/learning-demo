package android.stack.staticmodifier;

public class Son extends Farther {
    public static final String SON_FINAL = "子类静态常量";

    public static String SON = "子类静态变量";

    static {
        System.out.println(SON_FINAL);
        System.out.println(SON);
        System.out.println("子类静态代码块");
    }

    public String son = "子类非静态变量";

    {
        System.out.println(son);
        System.out.println("子类非静态代码块");
    }


    Son() {
        System.out.println("子类构造函数");
    }
}
