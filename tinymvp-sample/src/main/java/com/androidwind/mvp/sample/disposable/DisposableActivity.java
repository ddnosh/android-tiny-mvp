package com.androidwind.mvp.sample.disposable;

import android.widget.Toast;

import com.androidwind.mvp.sample.BaseDisposableActivity;
import com.androidwind.mvp.sample.R;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class DisposableActivity extends BaseDisposableActivity<DisposablePresenter, DisposableModel> implements DisposableContract.View {

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
        Toast.makeText(this, bool ? "Disposable Success" : "Disposable Fail", Toast.LENGTH_SHORT).show();
    }
}
