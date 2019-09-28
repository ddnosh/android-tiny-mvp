package com.androidwind.mvp.sample.rxlifecycle;

import android.widget.Toast;

import com.androidwind.mvp.sample.BaseRxLifecycleActivity;
import com.androidwind.mvp.sample.R;
import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class RxLifecycleActivity extends BaseRxLifecycleActivity<RxLifecyclePresenter, RxLifecycleModel> implements RxLifecycleContract.View {

    @Override
    protected int getContentView() {
        return R.layout.activity_blank;
    }

    @Override
    protected void init() {
        mPresenter.sendMsg();
    }

    @Override
    public void updateMsg(Boolean bool) {
        Toast.makeText(this, bool ? "RxLifecycle Success" : "RxLifecycle Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.<T>bindToLifecycle();
    }
}
