package android.stack.pkg1;

public class Pkg1Test {

    /**
     * 同个包中
     */
    private void samePackageTest(){
        Outer outer = new Outer();
        /**
         * 同个包里可以访问任意public、protected、无修饰符修饰的成员变量
         */
        System.out.println(outer.objectPublic.toString());
        System.out.println(outer.objectProtected.toString());
        System.out.println(outer.objectNone.toString());

        /**
         * 同个包里可以访问任意public、protected、无修饰符修饰的成员方法
         */
        outer.methodPublic();
        outer.methodProtected();
        outer.methodNone();


        /**
         * 无访问权限修饰符的外部类，只能在同类、同包中访问
         */
        Outer1 outer1 = new Outer1();
        System.out.println(outer1.objectPublic.toString());


        /**
         * static修饰的内部类在不同类中，可以使用外部类名.内部类名来实例化。
         * 非static修饰的内部类在不同类中，可以使用外部类的实例名称.new 内部类名来实例化。
         */
        Outer.InnerPublic innerPublic = outer.new InnerPublic();
        Outer.InnerProtected innerProtected = outer.new InnerProtected();
        Outer.InnerNone innerNone = outer.new InnerNone();
        Outer.InnerPublicStatic innerPublicStatic = new Outer.InnerPublicStatic();
        Outer.InnerProtectedStatic innerProtectedStatic = new Outer.InnerProtectedStatic();
        Outer.InnerNoneStatic innerNoneStatic = new Outer.InnerNoneStatic();

    }



}
