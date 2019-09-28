package com.androidwind.mvp.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.androidwind.mvp.sample.autodispose.AutodisposeActivity;
import com.androidwind.mvp.sample.disposable.DisposableActivity;
import com.androidwind.mvp.sample.rxlifecycle.RxLifecycleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn1, btn2, btn3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                startActivity(new Intent(this, DisposableActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, RxLifecycleActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this, AutodisposeActivity.class));
                break;
        }

    }
}
