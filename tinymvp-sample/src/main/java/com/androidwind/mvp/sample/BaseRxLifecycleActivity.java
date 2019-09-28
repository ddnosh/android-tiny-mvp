package com.androidwind.mvp.sample;

import android.os.Bundle;

import com.androidwind.mvp.BaseRxLifecycleContract;
import com.androidwind.mvp.TUtil;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public abstract class BaseRxLifecycleActivity<P extends BaseRxLifecycleContract.BasePresenter, M extends BaseRxLifecycleContract.BaseModel>
        extends RxAppCompatActivity implements BaseRxLifecycleContract.BaseView {

    public P mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());

        mPresenter = TUtil.getInstance(this, 0);
        M model = TUtil.getInstance(this, 1);
        if (mPresenter != null) {
            mPresenter.attachView(this);
            mPresenter.attachModel(model);
        }

        init();
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }

        super.onDestroy();
    }

    protected abstract int getContentView();

    protected abstract void init();
}
