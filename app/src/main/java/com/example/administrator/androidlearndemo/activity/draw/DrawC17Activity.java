package com.example.administrator.androidlearndemo.activity.draw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.example.administrator.androidlearndemo.R;

public class DrawC17Activity extends AppCompatActivity {

    private static String TAG = "aaaa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_c17);
        main();
    }


    public void main(){
        Log.e(TAG, "getvalue: "+TextUtils.split("1=2=3=4==", "=") );;
    }
}
