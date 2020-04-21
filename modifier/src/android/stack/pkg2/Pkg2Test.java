package android.stack.pkg2;


import android.stack.pkg1.Outer;

public class Pkg2Test {


    /**
     * 不同包中
     */
    private void differentPackageTest(){

        Outer outer = new Outer();
        /**
         * 不同包里可以访问任意public修饰的成员变量
         */
        System.out.println(outer.objectPublic.toString());

        /**
         * 不同包里可以访问任意public修饰的成员方法
         */
        outer.methodPublic();





        Outer.InnerPublic innerPublic = outer.new InnerPublic();
        Outer.InnerPublicStatic innerPublicStatic = new Outer.InnerPublicStatic();


    }




}
