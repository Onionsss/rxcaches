package onionsss.it.netrequest;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

/**
 * 作者：张琦 on 2016/7/22 14:59
 * 需要在Applicaiton里配置
 *
    public static RequestQueue mVolleyQueue;

    private void VolleyOption() {
    mVolleyQueue = Volley.newRequestQueue(this);
 }

 */
public class VolleyUtil {
    private static VolleyUtil mVolleyUtil = new VolleyUtil();
    public static VolleyUtil getInstance(){
        return mVolleyUtil;
    }
    private VolleyUtil(){}

    /**
     * Volley Get请求
     * @param url
     * @param volleyListener
     */
    public static void VolleyGet(String url,final VolleyGetListener volleyListener){
        StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                if (volleyListener != null) {
                    volleyListener.onSuccess(s);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyListener != null) {
                    volleyListener.onFaild(volleyError);
                }
            }
        });

        MyApplication.mVolleyQueue.add(sr);
    }

    /**
     * Volley Post请求
     * @param url
     * @param volleyListener
     * @param map
     */
    public static void VolleyPost(String url,final Map<String,String> map, final VolleyGetListener volleyListener){
        StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                if (volleyListener != null) {
                    volleyListener.onSuccess(s);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyListener != null) {
                    volleyListener.onFaild(volleyError);
                }
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };

        MyApplication.mVolleyQueue.add(sr);
    }
    interface VolleyGetListener{
        /**
         * 成功时候的回调
         * @param json 服务器返回的数据
         */
        void onSuccess(String json);

        /**
         * 失败时候的回调
         * @param volleyError 异常
         */
        void onFaild(VolleyError volleyError);
    }
}
