package android.stack.router_api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2020/4/20 23:16
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class Router {

    private static Router sInstance;
    private static Context sContext;


    public Router(Context context) {
        sContext = context;
    }

    /**
     * 路由表
     */
    private static Map<String, Class<? extends Activity>> sRoutes = new HashMap<>();

    /**
     * 单例模式，保证路由表的唯一性
     *
     * @return
     */
    public static Router getInstance(Context context) {
        if (sInstance == null) {
            synchronized (Router.class) {
                if (sInstance == null) {
                    sInstance = new Router(context);
                }
            }
        }
        return sInstance;
    }


    /**
     * 注册
     *
     * @param path
     * @param cls
     */
    public void register(String path, Class<? extends Activity> cls) {
        sRoutes.put(path, cls);
    }


    /**
     * 路由启动
     */
    public void startActivity(String path){
        Class<? extends Activity> cls = sRoutes.get(path);
        if (cls==null){
            return;
        }
        Intent intent = new Intent(sContext,cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        sContext.startActivity(intent);
    }



}
