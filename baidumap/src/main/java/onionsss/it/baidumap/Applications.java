package onionsss.it.baidumap;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * 作者：张琦 on 2016/8/20 22:32
 */
public class Applications extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
    }
}
