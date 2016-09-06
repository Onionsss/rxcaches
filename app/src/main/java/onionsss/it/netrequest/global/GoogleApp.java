package onionsss.it.netrequest.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by sy_heima on 2016/7/11.
 */
public class GoogleApp extends Application {
    //全局的context
    public static Context sContext ;
    public static Handler mainHandler ;
    public static RequestQueue mVolleyQueue;

    private void VolleyOption() {
        mVolleyQueue = Volley.newRequestQueue(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        mainHandler = new Handler();
        VolleyOption();
//        ImageLoaderConfiguration configuration = ImageLoaderConfiguration
//                .createDefault(this);
//        ImageLoader.getInstance().init(configuration);
    }
}
