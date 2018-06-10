package com.example.qiudeli.livedemo.ui.activity;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.example.qiudeli.livedemo.R;
import com.example.qiudeli.livedemo.entity.UserInfo;

public class AnotherActivity extends AppCompatActivity {
    private EditText edContent;
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        UserInfo.getInstance().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String content) {
                tvContent.setText(content);
            }
        });
        initView();
        initData();
    }

    private void initView() {
        edContent = findViewById(R.id.ed_content);
        tvContent = findViewById(R.id.textView2);
        edContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                UserInfo.getInstance().setContent(editable.toString());
            }
        });
    }

    private void initData() {
    }
}
