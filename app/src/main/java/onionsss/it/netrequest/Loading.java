package onionsss.it.netrequest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import java.util.List;

import onionsss.it.netrequest.global.Utils;

/**
 * 作者：张琦 on 2016/7/23 19:37
 */
public abstract class Loading extends FrameLayout{
    private View LoadingPage;
    private View SuccessPage;
    private View ErrorPage;
    public Loading(Context context) {
        this(context,null);
        initView();
    }

    public Loading(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Loading(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView() {
        if(LoadingPage == null){
            LoadingPage = View.inflate(getContext(),R.layout.loading,null);
        }
        addView(LoadingPage);

        if(SuccessPage == null){
            SuccessPage = getSuccessView();
        }
        addView(SuccessPage);

        if(ErrorPage == null){
            ErrorPage = View.inflate(getContext(),R.layout.error,null);
        }

        showPage();

        getData();
    }

    private void getData() {
        new Thread(){
            @Override
            public void run() {
                Object obj =  getSubData();
                currentStus = check(obj);

                Utils.runOnUIThread(new Runnable() {
                    @Override
                    public void run() {

                        showPage();
                    }
                });
            }
        }.start();
    }

    private PageStus check(Object obj) {
        if(obj == null){
            return PageStus.error;
        }else if(obj instanceof List){
            if(((List) obj).size() == 0){
                return PageStus.error;
            }else{
                return PageStus.success;
            }
        }
        return PageStus.success;
    }

    protected abstract Object getSubData();

    enum PageStus{
        loading,success,error
    }

    private PageStus currentStus = PageStus.loading;

    private void showPage() {
        LoadingPage.setVisibility(GONE);
        SuccessPage.setVisibility(GONE);
        ErrorPage.setVisibility(GONE);

        switch(currentStus){
            case loading:
                LoadingPage.setVisibility(VISIBLE);
            break;
            case success:
                SuccessPage.setVisibility(VISIBLE);
                break;
            case error:
                ErrorPage.setVisibility(VISIBLE);
                break;
        }
    }

    public abstract View getSuccessView();

    public PageStus getCurrentStus(){
        return currentStus;
    }

    public boolean changeStus(PageStus stus){
        if(stus != null){
            currentStus = stus;
        }else{
            return false;
        }
        return true;
    }
}
