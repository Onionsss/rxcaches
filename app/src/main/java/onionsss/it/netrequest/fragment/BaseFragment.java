package onionsss.it.netrequest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import onionsss.it.netrequest.Loading;
import onionsss.it.netrequest.MainActivity;

/**
 * 作者：张琦 on 2016/7/23 20:01
 */
public abstract class BaseFragment extends Fragment{

    public MainActivity mMainAct;
    public Loading mLoading;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainAct = (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mLoading = new Loading(getContext()) {
            @Override
            protected Object getSubData() {
                return initData();
            }

            @Override
            public View getSuccessView() {
                return initViews();
            }
        };
        return mLoading;
    }

    public abstract View initViews();

    public abstract Object initData();
}
