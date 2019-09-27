package com.androidwind.mvp.sample;

import android.widget.Toast;

public class MainActivity extends BaseActivity<MainPresenter, MainModel> implements MainContract.View {

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        mPresenter.sendMsg();
    }

    @Override
    public void updateMsg(Boolean bool) {
        Toast.makeText(this, bool ? "success" : "fail", Toast.LENGTH_SHORT).show();
    }
}
