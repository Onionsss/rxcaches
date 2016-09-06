package onionsss.it.retrofitrxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.UnknownHostException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn1)
    Button mBtn1;
    @Bind(R.id.btn2)
    Button mBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.btn1,R.id.btn2})
    public void click(View view){
        switch(view.getId()){
            case R.id.btn1:
                getData();
            break;
        }
    }

    /**
     * 访问网络
     */
    private void getData() {
        RetrofitUtils.getInstance(this).getNews().refreshNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                /**
                 * map  将拿到的缓存对象 转化为实体bean
                 */
                .map(moudle -> moudle.getResultModel())
                /**
                 * 有网的情况 会走两次
                 * 只拿一次的
                 */
                .first()
                .subscribe(this::showData,this::error
                ,() -> Toast.makeText(this,"OK", Toast.LENGTH_SHORT).show());
    }

    public void showData(NewsList list){
        Toast.makeText(this,list.getNews().get(0).toString(), Toast.LENGTH_SHORT).show();
    }

    public void error(Throwable t){
        Toast.makeText(this,t.toString(), Toast.LENGTH_SHORT).show();
        if(t instanceof InterruptedException){
            Toast.makeText(this,"没有网络", Toast.LENGTH_SHORT).show();
        }
        if(t instanceof UnknownHostException)
            Toast.makeText(this,"没有网络啊", Toast.LENGTH_SHORT).show();
    }
}
