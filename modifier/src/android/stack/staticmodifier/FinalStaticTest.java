package android.stack.staticmodifier;

public class FinalStaticTest {

    public static void main(String[] args){
        /**
         * 常量在编译阶段会存入调用类的常量池中，本质上没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化。
         * 实际上当前类并没有调用类的符号引用入口，这两个类在编译成class之后就不存在任何联系。
         */
        System.out.println(Son.SON_FINAL);
    }
}
