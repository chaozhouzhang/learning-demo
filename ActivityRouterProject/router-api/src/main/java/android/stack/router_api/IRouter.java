package android.stack.router_api;

import android.app.Activity;

import java.util.Map;

/**
 * Created on 2020/4/21 11:01
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public interface IRouter {


    /**
     * 加载路由
     * @param routes
     */
    void onRouterLoad(Map<String,? extends Activity> routes);
}
