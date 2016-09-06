package onionsss.it.netrequest;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * 作者：张琦 on 2016/7/22 15:11
 */
public class MyApplication extends Application{

    public static RequestQueue mVolleyQueue;

    private void VolleyOption() {
        mVolleyQueue = Volley.newRequestQueue(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        VolleyOption();

    }
}
