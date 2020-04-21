package android.stack.pkg1;

/**
 * 外部类不能使用private和protected修饰符修饰。
 * 一个源文件可以存在多个与源文件名不同的外部类。
 * 与源文件同名的外部类，可以使用public修饰符修饰，也可以无修饰符。
 * 其他与源文件不同名的外部类只能使用无修饰符。
 * 使用无修饰符的外部类是默认访问级别的，同类、同包可以访问，子类、不同包的不能访问。
 */
public  class Outer {
    /**
     * 公有成员变量
     */
    public Object objectPublic = new Object();

    /**
     * 受保护的成员变量
     */
    protected Object objectProtected = new Object();

    /**
     * 无修饰符的成员变量
     */
    Object objectNone = new Object();

    /**
     * 私有的成员变量
     */
    private Object objectPrivate = new Object();


    /**
     * 公有成员方法
     */
    public void methodPublic() {

    }

    /**
     * 受保护的成员方法
     */
    protected void methodProtected() {

    }

    /**
     * 无修饰符的成员方法
     */
    void methodNone() {

    }

    /**
     * 私有成员方法
     */
    private void methodPrivate() {

    }


    /**
     * 同个类中
     */
    private void sameClassTest(){
        /**
         * 同类里可以访问任意访问权限修饰符修饰的成员变量
         */
        System.out.println(objectPublic.toString());
        System.out.println(objectProtected.toString());
        System.out.println(objectNone.toString());
        System.out.println(objectPrivate.toString());

        /**
         * 同类里可以访问任意访问权限修饰符修饰的方法
         */
        methodPublic();
        methodProtected();
        methodNone();
        methodPrivate();

    }



    /**
     * public修饰的内部类是公开的，同类、同包、子类、不同包都可以访问
     */
    public class InnerPublic {

    }

    /**
     * protected修饰的内部类是受保护的，同类、同包、子类可以访问，不同包的不能访问
     */
    protected class InnerProtected {

    }

    /**
     * 无修饰符修饰的内部类是默认访问级别的，同类、同包可以访问，子类、不同包的不能访问
     */
    class InnerNone {

    }

    /**
     * private修饰的内部类是私有的，同类可以访问，同包、子类、不同包的不能访问
     */
    private class InnerPrivate {

    }


    /**
     * 没有static修饰的内部类不能使用外部类使用.分隔符进行实例化操作，必须用外部类的实例来进行实例化类中类操作。
     */
    static public class InnerPublicStatic {

    }

    static protected class InnerProtectedStatic {

    }

    static class InnerNoneStatic {

    }

    static private class InnerPrivateStatic {

    }

}


class Outer1 {
    public Object objectPublic = new Object();
}

