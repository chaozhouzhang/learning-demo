package android.stack.router_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created on 2020/4/21 12:46
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */

/**
 * 指定注解作用在类上面
 */
@Target(ElementType.TYPE)
/**
 * @author zhangchaozhou
 * 设置注解可以保留在编译后的class文件中
 */
@Retention(RetentionPolicy.CLASS)
public @interface Route {
    String value();
}
