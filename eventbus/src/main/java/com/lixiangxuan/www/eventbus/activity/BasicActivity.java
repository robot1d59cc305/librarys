package com.lixiangxuan.www.eventbus.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lixiangxuan.www.eventbus.R;
import com.lixiangxuan.www.eventbus.event.MessageEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * <p>Description: </p>
 * <p>Company: www.lixiangxuan.com</p>
 *
 * @author 李湘旋
 * @version 1.0
 * @className BasicActivity
 * @date 2018/7/24 14:11
 */
public class BasicActivity extends AppCompatActivity {

    private Button sendevent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        super.setContentView(R.layout.basic);

        init();

    }

    public void init() {

        sendevent = findViewById(R.id.basic_button1_sendevent);

        sendevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 这里是发布者角色,发布者可以发布多个不同的事件.
                EventBus.getDefault().post(new MessageEvent("使用EventBus工具成功发送了信息"));
                BasicActivity.super.finish();
            }
        });

    }

}