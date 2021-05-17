package com.example.administrator.androidlearndemo.activity.socket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bizideal.smarthome.socket.ConstantUtil;
import com.bizideal.smarthome.socket.LoginCallback;
import com.bizideal.smarthome.socket.SocketClient;
import com.example.administrator.androidlearndemo.R;
import com.example.administrator.androidlearndemo.bean.MyStaticBean;

public class SocketClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket_client);

        SocketClient.getInstance().creatConnect();
        SocketClient.getInstance().login(new LoginCallback() {
            @Override
            public void onEvent(String s) {
                Log.e("=====tag======", "============onEvent: 网络监听中");
                MyStaticBean.connect = s.equals(ConstantUtil.Success);
            }
        });


    }
}
