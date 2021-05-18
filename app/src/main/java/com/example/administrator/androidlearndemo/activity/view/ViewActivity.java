package com.example.administrator.androidlearndemo.activity.view;

import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.administrator.androidlearndemo.R;

public class ViewActivity extends AppCompatActivity {

    private String TAG = "viewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
    }

    public void test(final View view) {
        Log.e(TAG, "test: " + view.getY());
//        view.setY(view.getY()+100);
//        ObjectAnimator translationY = ObjectAnimator.ofFloat(view, "TranslationY", 100).setDuration(1000);
//        translationY.start();
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    Log.e(TAG, "run: " + i);
                    ObjectAnimator translationY2 = ObjectAnimator.ofFloat(view, "TranslationY", 100).setDuration(1000);
                    translationY2.start();
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        });
    }

}
