package onionsss.it.nohttp;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;

/**
 * 作者：张琦 on 2016/7/24 14:23
 */
public class MyApplicaiton extends Application{
    /**
     * 继承application
     */
    public static Application instance;
    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = this;
        NoHttp.initialize(this);

        /**
         * 设置NoHttp日志
         */
        Logger.setDebug(true);
        Logger.setTag("NoHttp");

        VolleyOption();
    }
    public static RequestQueue mVolleyQueue;

    private void VolleyOption() {
        mVolleyQueue = Volley.newRequestQueue(this);
    }
    public static Application getInstance(){
        return instance;
    }
}
