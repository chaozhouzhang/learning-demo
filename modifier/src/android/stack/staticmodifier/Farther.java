package android.stack.staticmodifier;

public class Farther {

    public static final String FATHER_FINAL = "父类静态常量";

    public static String FARTHER = "父类静态变量";

    static {
        System.out.println(FATHER_FINAL);
        System.out.println(FARTHER);
        System.out.println("父类静态代码块");
    }

    public String farther = "父类非静态变量";

    {
        System.out.println(farther);
        System.out.println("父类非静态代码块");
    }



    Farther(){
        System.out.println("父类构造函数");
    }


}
