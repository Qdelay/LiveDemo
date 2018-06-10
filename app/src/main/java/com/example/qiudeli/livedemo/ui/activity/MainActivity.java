package com.example.qiudeli.livedemo.ui.activity;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.qiudeli.livedemo.R;
import com.example.qiudeli.livedemo.entity.UserInfo;

public class MainActivity extends AppCompatActivity {
    private TextView tvUserInfo;
    private Button btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        tvUserInfo = findViewById(R.id.tv_user_info);
        btnClick = findViewById(R.id.button);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, AnotherActivity.class);
                startActivity(intent);
            }
        });
        UserInfo.getInstance().setContent("hello");
    }

    private void initData() {
        UserInfo.getInstance().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String content) {
                tvUserInfo.setText(content);
            }
        });
    }
}
