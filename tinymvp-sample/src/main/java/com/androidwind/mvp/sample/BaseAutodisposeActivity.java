package com.androidwind.mvp.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.androidwind.mvp.BaseAutodisposeContract;
import com.androidwind.mvp.TUtil;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public abstract class BaseAutodisposeActivity<P extends BaseAutodisposeContract.BasePresenter, M extends BaseAutodisposeContract.BaseModel>
        extends AppCompatActivity implements BaseAutodisposeContract.BaseView {

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
