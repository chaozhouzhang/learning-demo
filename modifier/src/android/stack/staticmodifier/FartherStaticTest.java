package android.stack.staticmodifier;

public class FartherStaticTest {
    public static void main(String[] args) {
        /**
         * 对于静态变量，只有直接定义这个变量的类才会被初始化，通过其子类来引用父类中定义的静态变量，只会触发父类的初始化，不会触发子类的初始化。
         */
        System.out.println(Son.FARTHER);
    }
}
