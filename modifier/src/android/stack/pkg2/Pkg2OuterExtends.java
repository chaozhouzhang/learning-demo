package android.stack.pkg2;

import android.stack.pkg1.Outer;

public class Pkg2OuterExtends extends Outer {


    /**
     * 不同包的子类
     */
    private void differentPackageSubClassTest() {
        Pkg2OuterExtends pkg2OuterExtends = new Pkg2OuterExtends();
        /**
         * 不同个包里的子类，可以使用子类的实例访问public、protected饰符修饰的成员变量
         */
        System.out.println(pkg2OuterExtends.objectPublic.toString());
        System.out.println(pkg2OuterExtends.objectProtected.toString());

        /**
         * 不同个包里的子类，可以使用子类的实例访问public、protected修饰的成员方法
         */
        pkg2OuterExtends.methodPublic();
        pkg2OuterExtends.methodProtected();


        /**
         * 不同包的外部类的子类，可以访问protected修饰的变量、方法、内部类，但不能实例化protected修饰的内部类、外部类。
         * 不同包的外部类的子类，不可以访问无修饰符的变量、方法、内部类，也不能实例无修饰符的内部类、外部类。
         */
        Outer.InnerPublic innerPublic = pkg2OuterExtends.new InnerPublic();
        Outer.InnerPublicStatic innerPublicStatic = new Outer.InnerPublicStatic();
//        Outer.InnerProtected innerProtected = pkg2OuterExtends.new InnerProtected();
//        Outer.InnerProtectedStatic innerProtectedStatic = new Outer.InnerProtectedStatic();



    }
}
