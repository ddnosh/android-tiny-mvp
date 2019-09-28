package com.androidwind.mvp.sample.autodispose;

import android.widget.Toast;

import com.androidwind.mvp.sample.BaseAutodisposeActivity;
import com.androidwind.mvp.sample.BaseDisposableActivity;
import com.androidwind.mvp.sample.R;
import com.androidwind.mvp.sample.disposable.DisposableContract;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class AutodisposeActivity extends BaseAutodisposeActivity<AutodisposePresenter, AutodisposeModel> implements AutodisposeContract.View {

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
        Toast.makeText(this, bool ? "Autodispose Success" : "Autodispose Fail", Toast.LENGTH_SHORT).show();
    }
}
