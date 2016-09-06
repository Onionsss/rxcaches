package onionsss.it.netrequest.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import onionsss.it.netrequest.Loading;

public abstract class BaseActivity extends AppCompatActivity {

    private Loading mLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLoading = new Loading(this) {
            @Override
            protected Object getSubData() {
                return initData();
            }

            @Override
            public View getSuccessView() {
                return initViews();
            }
        };
        setContentView(mLoading);
    }

    public abstract View initViews();

    public abstract Object initData();

}
