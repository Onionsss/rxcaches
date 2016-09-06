package onionsss.it.nohttp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;
import com.yolanda.nohttp.rest.SimpleResponseListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//
    private RequestQueue mRequestQueue;
    private String url = "http://192.168.182.2:8080/HttpServer/cookie";
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    mRequestQueue = NoHttp.newRequestQueue();
        initData();
    }
    public void initData(){
        findViewById(R.id.btn).setOnClickListener(this);
        mTv = (TextView) findViewById(R.id.tv);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn:
                login();
//                web();
            break;
        }
    }

    private void web() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }

    private void login() {
        Request<String> stringRequest = NoHttp.createStringRequest(url, RequestMethod.POST);
        Map<String,String> map = new HashMap<>();
        map.put("userName","yolanda");
        map.put("userPwd","123");
        stringRequest.add(map);
        mRequestQueue.add(0, stringRequest, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int i, Response<String> response) {
                Toast.makeText(getApplicationContext(),response.get(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailed(int i, String s, Object o, Exception e, int i1, long l) {

            }

        });
    }


}
