package com.example.administrator.androidlearndemo.activity.socket;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bizideal.smarthome.socket.ControlUtils;
import com.bizideal.smarthome.socket.SocketClient;
import com.example.administrator.androidlearndemo.R;
import com.example.administrator.androidlearndemo.bean.MyStaticBean;

public class SocketGetClientActivity extends AppCompatActivity {

    private TextView textView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket_get_client);
        textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ControlUtils.setUser("bizideal", "123456", "18.1.10.7");
                SocketClient.getInstance().creatConnect();
            }
        });
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Log.e("======tag======", "run: 网络状态显示中");
            textView.setText(MyStaticBean.connect ? "网络连接成功" : "网络连接失败");
            handler.postDelayed(runnable, 1000);
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        handler.post(runnable);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }
}
