package com.example.administrator.androidlearndemo.window;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.example.administrator.androidlearndemo.R;

public class WindowActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_window);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.textview_title);

    }
}
