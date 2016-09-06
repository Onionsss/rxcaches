package onionsss.it.netrequest;

import android.view.View;

import onionsss.it.netrequest.ui.BaseActivity;

public class MainActivity extends BaseActivity{

    @Override
    public Object initData() {
        return null;
    }

    @Override
    public View initViews() {
        View view = View.inflate(this, R.layout.activity_main, null);
        return view;
    }

}
