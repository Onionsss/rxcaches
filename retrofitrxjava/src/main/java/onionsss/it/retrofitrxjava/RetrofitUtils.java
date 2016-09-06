package onionsss.it.retrofitrxjava;

import android.content.Context;

import com.cpoopc.retrofitrxcache.BasicCache;
import com.cpoopc.retrofitrxcache.RxCacheCallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：张琦 on 2016/9/6 21:15
 */
public class RetrofitUtils {
    private static OkHttpClient mHttpClientBuilder;
    private Context mContext;
    private static RetrofitUtils mRetrofitUtils;
    private Retrofit mRetrofit;

    private RetrofitUtils(Context context){
        mContext = context.getApplicationContext();
    }

    public static RetrofitUtils getInstance(Context context){
        if(mRetrofitUtils == null)
            synchronized (RetrofitUtils.class){
                if(mRetrofitUtils == null)
                    mRetrofitUtils = new RetrofitUtils(context);
            }

        return mRetrofitUtils;
    }

    public Api getNews(){
        if(mRetrofit == null) {
            mRetrofit = new Retrofit.Builder().baseUrl("http://dota2xufserver.duapp.com").client(getOkHttpClient())
           .addConverterFactory(GsonConverterFactory.create())
                    /**
                     * 配置缓存   就一句话  需要外部依赖
                     */
           .addCallAdapterFactory(new RxCacheCallAdapterFactory(BasicCache.fromCtx(mContext)))
                   .build();
        }

        return mRetrofit.create(Api.class);
    }
    private OkHttpClient getOkHttpClient() {
        if (mHttpClientBuilder == null) {
                    mHttpClientBuilder = new OkHttpClient.Builder()
                            .connectTimeout(1, TimeUnit.SECONDS).build();
        }
        return mHttpClientBuilder;
    }
}
