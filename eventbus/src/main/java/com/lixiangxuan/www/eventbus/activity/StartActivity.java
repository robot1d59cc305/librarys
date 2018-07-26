package com.lixiangxuan.www.eventbus.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lixiangxuan.www.eventbus.R;
import com.lixiangxuan.www.eventbus.event.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * <p>Description: </p>
 * <p>Company: www.lixiangxuan.com</p>
 * 这里是订阅者,订阅者可以接受不同的由发布者发出的事件.
 * @author 李湘旋
 * @version 1.0
 * @className StartActivity
 * @date 2018/7/23 10:22
 */
public class StartActivity extends AppCompatActivity {

    private Button gobasicactivity;

    private TextView content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        super.setContentView(R.layout.activity_main);

        // 接受数据方需要注册.
        EventBus.getDefault().register(this);

        init();

    }

    public void init() {

        gobasicactivity = (Button) findViewById(R.id.activity_main_button1_gobasicactivity);
        content = (TextView) findViewById(R.id.activity_main_textview1_content);

        gobasicactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this,BasicActivity.class);
                StartActivity.super.startActivity(intent);
            }
        });

    }

    /**
     * 业务类,这个是在其它代码当中的某一个地方调用了像EventBus.getDefault().post() 这样的代码之后处理了其它的一个组件像这个Activity组件发送消息. 订阅消息,可以编写多个订阅者的业务方法实现.
     * @param messageEvent
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void sendMessageEvent(MessageEvent messageEvent) {

        content.setText(messageEvent.getMessage());

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

        EventBus.getDefault().unregister(this);

    }

}